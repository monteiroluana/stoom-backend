package br.com.qualification.stoom.controller;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



import br.com.qualification.stoom.controller.dto.LocateDto;
import br.com.qualification.stoom.controller.form.LocateForm;
import br.com.qualification.stoom.controller.form.LocateFormUpdate;
import br.com.qualification.stoom.entity.LocateEntity;
import br.com.qualification.stoom.repository.LocateRepository;

@RestController
@RequestMapping(value="/locate")
public class LocateController {
	
	@Autowired
	private LocateRepository locateRepository;
	
	
	@GetMapping
	public List<LocateDto> list() {
		
		List<LocateEntity> locateList = locateRepository.findAll();
		
		return  LocateDto.converter(locateList);

	}
	
	@PostMapping
	public ResponseEntity<LocateDto> create(@RequestBody @Valid LocateForm form, UriComponentsBuilder uriBuilder) throws URISyntaxException, MalformedURLException {
		
		LocateEntity locate = form.converter();
		
		if (locate.getLatitude() == null || locate.getLongitude() == null) {
		
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(locate.urlAddress(), String.class);

		    JSONObject obj = (JSONObject) new JSONObject(result).getJSONArray("results").get(0);
		    JSONObject location = obj.getJSONObject("geometry").getJSONObject("location");
		    
		    float lat = Float.parseFloat(location.get("lat").toString());
		    float lng = Float.parseFloat(location.get("lng").toString());
	
		    locate.setLatitude(lat);
		    locate.setLongitude(lng);	   		    
		}
		
		locateRepository.save(locate);
		
		URI uri = uriBuilder.path("/locate/{id}").buildAndExpand(locate.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new LocateDto(locate));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocateDto> detail(@PathVariable int id) {
		Optional<LocateEntity> locate = locateRepository.findById(id);
		if (locate.isPresent()) {
			return ResponseEntity.ok(new LocateDto(locate.get()));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LocateDto> update (@PathVariable int id, @RequestBody @Valid LocateFormUpdate form){
		Optional<LocateEntity> locateUpdate = locateRepository.findById(id);
		
		if (locateUpdate.isPresent()) {
			LocateEntity locate = form.update(id, locateRepository);
			return ResponseEntity.ok(new LocateDto(locate));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable int id) {
		Optional<LocateEntity> locate = locateRepository.findById(id);
		if (locate.isPresent()) {
			locateRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}

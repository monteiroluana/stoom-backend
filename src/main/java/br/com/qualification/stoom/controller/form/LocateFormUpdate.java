package br.com.qualification.stoom.controller.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.qualification.stoom.entity.LocateEntity;
import br.com.qualification.stoom.repository.LocateRepository;

public class LocateFormUpdate {

	@NotNull @NotEmpty
	private String streetName;
	@NotNull
	private int number;
	private String complement;
	@NotNull @NotEmpty
	private String neighboudhood;
	@NotNull @NotEmpty
	private String city;
	@NotNull @NotEmpty @Column(length = 2)
	private String state;
	@NotNull @NotEmpty
	private String country;
	@NotNull @NotEmpty
	private String zipcode;
	private Float latitude;
	private Float longitude;
	
	
	public LocateEntity update(int id, LocateRepository locateRepository) {
		LocateEntity locate = locateRepository.getOne(id);
		
		locate.setStreetName(this.streetName);
		locate.setNumber(this.number);
		locate.setComplement(this.complement);
		locate.setNeighboudhood(this.neighboudhood);
		locate.setCity(this.city);
		locate.setState(this.state);
		locate.setCountry(this.country);
		locate.setZipcode(this.zipcode);
		locate.setLatitude(this.latitude);
		locate.setLongitude(this.longitude);
		
		return locate;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getNeighboudhood() {
		return neighboudhood;
	}


	public void setNeighboudhood(String neighboudhood) {
		this.neighboudhood = neighboudhood;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public Float getLatitude() {
		return latitude;
	}


	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}


	public Float getLongitude() {
		return longitude;
	}


	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	
	
}

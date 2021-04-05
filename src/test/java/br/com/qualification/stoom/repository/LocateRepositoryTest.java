package br.com.qualification.stoom.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.qualification.stoom.entity.LocateEntity;


@DataJpaTest
public class LocateRepositoryTest {

	@Autowired
	private LocateRepository repository;
	
	@Test
	public void findLocateByStreetName() {
		String streetName = "Avenida Europa";
		LocateEntity locate = repository.findByStreetName(streetName);
		Assertions.assertNotNull(locate);
		Assertions.assertEquals(streetName, locate.getStreetName());
	}
	
}

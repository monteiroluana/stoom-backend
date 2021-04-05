package br.com.qualification.stoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qualification.stoom.entity.LocateEntity;

public interface LocateRepository extends JpaRepository<LocateEntity, Integer> {
	
	LocateEntity findByStreetName(String streetName);

}

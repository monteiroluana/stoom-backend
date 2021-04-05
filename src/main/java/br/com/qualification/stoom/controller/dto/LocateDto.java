package br.com.qualification.stoom.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.qualification.stoom.entity.LocateEntity;

public class LocateDto {
	
	private int id;
	private String streetName;
	private int number;
	private String complement;
	private String neighboudhood;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private Float latitude;
	private Float longitude;
	
	public LocateDto(LocateEntity locate) {
		this.id = locate.getId();
		this.streetName = locate.getStreetName();
		this.number = locate.getNumber();
		this.complement = locate.getComplement();
		this.neighboudhood = locate.getNeighboudhood();
		this.city = locate.getCity();
		this.state = locate.getState();
		this.country = locate.getCountry();
		this.zipcode = locate.getZipcode();
		this.latitude = locate.getLatitude();
		this.longitude = locate.getLongitude();
	}
	
	
	public static List<LocateDto> converter(List<LocateEntity> locateList) {
		return locateList.stream().map(LocateDto::new).collect(Collectors.toList());
	}


	public int getId() {
		return id;
	}


	public String getStreetName() {
		return streetName;
	}


	public int getNumber() {
		return number;
	}


	public String getComplement() {
		return complement;
	}


	public String getNeighboudhood() {
		return neighboudhood;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getCountry() {
		return country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public Float getLatitude() {
		return latitude;
	}


	public Float getLongitude() {
		return longitude;
	}
	
	
}

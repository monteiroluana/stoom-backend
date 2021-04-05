package br.com.qualification.stoom.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.qualification.stoom.entity.LocateEntity;

public class LocateForm {
	@NotNull @NotEmpty
	private String streetName;
	@NotNull
	private int number;
	private String complement;
	@NotNull @NotEmpty
	private String neighboudhood;
	@NotNull @NotEmpty
	private String city;
	@NotNull @NotEmpty
	private String state;
	@NotNull @NotEmpty
	private String country;
	@NotNull @NotEmpty
	private String zipcode;
	private Float latitude;
	private Float longitude;

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
	
	public LocateEntity converter() {
		
		return new LocateEntity(streetName, number, complement, neighboudhood, city, state, 
				country, zipcode, latitude, longitude);
		
	}
}

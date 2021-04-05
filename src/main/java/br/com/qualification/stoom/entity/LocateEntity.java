package br.com.qualification.stoom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="locate")
@Table(name="locate")
public class LocateEntity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String streetName;
	private int number;
	private String complement;
	private String neighboudhood;
	private String city;
	@Column(length = 2)
	private String state;
	private String country;
	private String zipcode;
	private Float latitude;
	private Float longitude;
	
		
	public LocateEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LocateEntity(String streetName, int number, String complement, String neighboudhood, String city,
			String state, String country, String zipcode, Float latitude, Float longitude) {
		super();
		this.streetName = streetName;
		this.number = number;
		this.complement = complement;
		this.neighboudhood = neighboudhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	public String urlAddress () {
		String address = "https://maps.googleapis.com/maps/api/geocode/json?address=";
		address += Integer.toString(this.number);
		address += "+";
		address += this.streetName.replaceAll(" ","+");
		address += ",+";
		address += this.city.replaceAll(" ","+");;
		address += ",+";
		address += this.state;
		address += "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
		
		return address;
	}
}

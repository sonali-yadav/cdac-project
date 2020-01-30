package com.salon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "salon_master")
public class Salon extends AbstractEntity {

	// data members
	private String salonName, address, contact1, contact2, description, latitude, longitude,imagePath;
	private Type salonType;
	private int homeServiceFlag, activeDeactive;
	private User user;
	private List<SalonServiceMapping> mappings;
	
	// default constructor
	public Salon() {
		super();
		System.out.println("Salon default constructor called.");
		user=new User();
		mappings=new ArrayList<>();
	}

	public Salon(String salonName, String address, String contact1, String contact2, String description,
			String latitude, String longitude, String imagePath, Type salonType, int homeServiceFlag, int activeDeactive,
			User user) {
		super();
		this.salonName = salonName;
		this.address = address;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.imagePath = imagePath;
		this.salonType = salonType;
		this.homeServiceFlag = homeServiceFlag;
		this.activeDeactive = activeDeactive;
		this.user = user;
		mappings=new ArrayList<>();
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Enumerated(EnumType.ORDINAL)
	public Type getSalonType() {
		return salonType;
	}

	public void setSalonType(Type salonType) {
		this.salonType = salonType;
	}

	public int getHomeServiceFlag() {
		return homeServiceFlag;
	}

	public void setHomeServiceFlag(int homeServiceFlag) {
		this.homeServiceFlag = homeServiceFlag;
	}

	public int getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(int activeDeactive) {
		this.activeDeactive = activeDeactive;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="users_pk")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "salon")
	public List<SalonServiceMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<SalonServiceMapping> mappings) {
		this.mappings = mappings;
	}

	@Override
	public String toString() {
		return "Salon [salonName=" + salonName + ", address=" + address + ", contact1=" + contact1 + ", contact2="
				+ contact2 + ", description=" + description + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", imagePath=" + imagePath + ", salonType=" + salonType + ", homeServiceFlag=" + homeServiceFlag
				+ ", activeDeactive=" + activeDeactive + ", user=" + user + ", mappings=" + mappings + "]";
	}
	
	//helper methods
	
	public void addMapping(SalonServiceMapping s) {
		mappings.add(s);
		s.setSalon(this);
	}
	public void removeMapping(SalonServiceMapping s) {
		mappings.remove(s);
		s.setSalon(null);
	}
}

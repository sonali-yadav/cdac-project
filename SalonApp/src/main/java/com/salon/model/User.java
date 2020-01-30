package com.salon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User extends AbstractEntity {
	// data members
	private String firstName, lastName, email, gender, contact1, contact2="",password;
	public int activeDeactive;
	private Role role;
	private List<Salon> salons;
	

	// default constructor
	public User() {
		super();
		salons=new ArrayList<>();
		System.out.println("User default constructor called.");
	}

	public User(String firstName, String lastName, String email, String gender, String contact1, String contact2,
			int activeDeactive,String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.activeDeactive = activeDeactive;
		this.password=password;
		this.role=role;
		salons=new ArrayList<>();
		
	}

	@Enumerated(EnumType.ORDINAL)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(unique = true)
	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	@Column
	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	public int getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(int activeDeactive) {
		this.activeDeactive = activeDeactive;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Salon> getSalons() {
		return salons;
	}

	public void setSalons(List<Salon> salons) {
		this.salons = salons;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", contact1=" + contact1 + ", contact2=" + contact2 + ", password=" + password + ", activeDeactive="
				+ activeDeactive + ", role=" + role + ", salons=" + salons + "]";
	}
	
	//helper methods
	
	public void addSalon(Salon s) {
		salons.add(s);
		s.setUser(this);
	}
	
	public void removeSalon(Salon s) {
		salons.remove(s);
		s.setUser(null);
	}
}

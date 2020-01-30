package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name="salon_service_mapping")
public class SalonServiceMapping extends AbstractEntity {
	
	//data members
	private  Salon salon;
	private Service service;
	private int serviceCost, homeServiceFlag, activeDeactive;
	
	public SalonServiceMapping() {
		super();
		System.out.println("inside salon service mapping def ctor");
		salon=new Salon();
		service=new Service();
	}

	@ManyToOne
	@JoinColumn(name="salon_master_pk")
	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	@ManyToOne
	@JoinColumn(name="service_master_pk")
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
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

	@Override
	public String toString() {
		return "SalonServiceMapping [salon=" + salon + ", service=" + service + ", serviceCost=" + serviceCost
				+ ", homeServiceFlag=" + homeServiceFlag + ", activeDeactive=" + activeDeactive + "]";
	}

	
}

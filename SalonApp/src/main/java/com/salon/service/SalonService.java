package com.salon.service;

import java.util.List;

import com.salon.model.Salon;

public interface SalonService {
	
	public int addSalon(Salon s);
	public String deactivateSalon(Long pk);
	public Salon updateSalonDetails(Long pk, Salon salon);
	public List<Salon> getAllSalons();
	public Salon getSalonDetails(Long pk);

}

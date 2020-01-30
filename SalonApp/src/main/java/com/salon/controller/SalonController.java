package com.salon.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.model.Salon;
import com.salon.service.SalonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/salons")
public class SalonController {

	@Autowired
	SalonService sservice;
	
	@PostMapping("/add")
	public int addSalon(@RequestBody Salon salon) {
		return sservice.addSalon(salon);
	}
	
	@GetMapping(value="/profile/{pk}")
	public Salon getSalon(@PathVariable("pk") Long pk) {
		return sservice.getSalonDetails(pk);
	}
	
	@GetMapping(value="/deactivate/{pk}")
	public Map<String,String> deactivate(@PathVariable("pk") Long pk) {
		return Collections.singletonMap("message",sservice.deactivateSalon(pk));
	}
	
	@PutMapping(value="/update")
	public Salon update(@RequestBody Salon user) {
		return sservice.updateSalonDetails(user.getPk(), user);
	}
}

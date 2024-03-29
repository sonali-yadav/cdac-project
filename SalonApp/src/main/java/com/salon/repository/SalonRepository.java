package com.salon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long>{

	Salon findByContact1(String cntct);
}

package com.salon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service_master")
public class Service extends AbstractEntity {
	private String serviceName, imagePath, description;
	private Category category;
	private List<SalonServiceMapping> mappings;

	public Service() {
		super();
		System.out.println("Service def ctor called");
		category = new Category();
		mappings = new ArrayList<>();
	}

	@Column
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_master_pk")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
	public List<SalonServiceMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<SalonServiceMapping> mappings) {
		this.mappings = mappings;
	}

	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", imagePath=" + imagePath + ", description=" + description
				+ ", category=" + category + ", mappings=" + mappings + "]";
	}

	// helper methods

	public void addMapping(SalonServiceMapping s) {
		mappings.add(s);
		s.setService(this);
	}

	public void removeMapping(SalonServiceMapping s) {
		mappings.remove(s);
		s.setService(null);
	}

}

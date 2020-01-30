package com.salon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category_master")
public class Category extends AbstractEntity {
	private String categoryName;
	private List<Service> services;
	
	public Category() {
		super();
		services=new ArrayList<>();
	}

	@Column
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", services=" + services + "]";
	}
	
	//helper methods
	public void addService(Service s) {
		services.add(s);
		s.setCategory(this);
	}
	
	public void removeService(Service s) {
		services.remove(s);
		s.setCategory(null);
	}
}

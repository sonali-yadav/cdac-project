package com.salon.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {

	private Long pk;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

}

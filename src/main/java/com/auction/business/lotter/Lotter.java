package com.auction.business.lotter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lotter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	
public Lotter() {
		super();
	}

	
	public Lotter(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	public Lotter(String un) {
		setName(un);	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]"; 
	}
}

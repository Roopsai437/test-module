package com.dxctraining.testsmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Test {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	public Test() {
	}
	public Test(String name) {

		this.name = name;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}

		if (arg == null || !(arg instanceof Test)) {
			return false;
		}

		Test that = (Test) arg;
		boolean isequal = this.id == that.id;
		return isequal;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
		
	

package com.tanzu.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Hello {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Choice a;

	@ManyToOne
	private Choice b;

	public Choice getA() {
		return a;
	}

	public Choice getB() {
		return b;
	}
}

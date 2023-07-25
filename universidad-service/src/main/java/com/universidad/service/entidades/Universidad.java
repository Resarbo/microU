package com.universidad.service.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Universidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private int areas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAreas() {
		return areas;
	}

	public void setAreas(int areas) {
		this.areas = areas;
	}

	public Universidad() {
		super();
	}

	public Universidad(int id, String nombre, int areas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.areas = areas;
	}

}
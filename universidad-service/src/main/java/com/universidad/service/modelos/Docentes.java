package com.universidad.service.modelos;

public class Docentes {
	private String nombre;
	private String especialidad;
	private int universidadId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getUniversidadId() {
		return universidadId;
	}

	public void setUniversidadId(int universidadId) {
		this.universidadId = universidadId;
	}

	public Docentes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

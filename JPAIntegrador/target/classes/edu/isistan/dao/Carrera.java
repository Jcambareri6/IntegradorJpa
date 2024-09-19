package edu.isistan.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Carrera {

	@IdCarrera
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdCarrera;

	@Column
	private String Nombre;

	@Column
	private int Anios;

	@ManyToMany
	private List<Estudiante> Estudiantes;

	public Carrera() {
		super();
		this.Estudiantes = new ArrayList<Estudiante>();
	}

	public int getIdCarrera() {
		return IdCarrera;
	}

	public int getNombre() {
		return Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public int getAnios() {
		return Anios;
	}

	public void setAnios(int Anios) {this.Anios = Anios;}

	public List<Estudiante> getEstudiantes() {
		return Estudiantes;
	}
}
	
}

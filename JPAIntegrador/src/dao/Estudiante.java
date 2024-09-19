package edu.isistan.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

	@Entity
	public class Estudiante{

		@NroLibretaUniversitaria
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int NroLibretaUniversitaria;
		@Column
		private String Nombre;
		@Column
		private String Apellido;
		@Column
		private int Edad;
		@Column
		private String Genero;
		@Column
		private String CiudadResidencia;
		@ManyToMany(mappedBy="Estudiantes", fetch=FetchType.LAZY)
		private List<Carrera> Carreras;

		public Estudiante() {
			super();
			this.Carreras = new ArrayList<Carrera>();
		}

		public Estudiante(String Nombre, String Apellido, int Edad, String Genero) {
			super();
			this.Nombre = Nombre;
			this.Apellido = Apellido;
			this.Edad = Edad;
			this.Genero = Genero;
		}

		public int getNroLibretaUniversitaria() {return NroLibretaUniversitaria;}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String Nombre) {
			this.Nombre = Nombre;
		}

		public String getApellido() {
			return Apellido;
		}

		public void setApellido(String Apellido) {
			this.Apellido = Apellido;
		}

		public int getEdad() {return Edad; }

		public void setEdad(int Edad) {this.Edad = Edad; }

		public String getGenero() {return Genero;}

		public void setGenero(String Genero) {this.Genero = Genero;}

		public List<Carrera> getCarreras() {
			return Carreras;
		}

	}


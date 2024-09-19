package edu.isistan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Carrera;
import edu.isistan.dao.Estudiante;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EjercicioIntegrador2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//dar de alta un estudiante

		//matricular un estudiante en una carrera
		Estudiante estudiante = new Estudiante("Joaquin","BosteroCambareri",22,"Masculino","Necochea");
		em.persist(estudiante);
		Estudiante estudiante = new Estudiante("Valentino","Malassisi",21,"Masculino","Necochea");
		em.persist(estudiante);
		Estudiante estudiante = new Estudiante("Paula","Manzalini",50,"Femenino","Madrid");
		em.persist(estudiante);
		Estudiante estudiante = new Estudiante("Neymar","Jr",32,"Masculino","Sao Paulo");
		em.persist(estudiante);
		Estudiante estudiante = new Estudiante("Lionel","Messi",37,"Masculino","Rosario");
		em.persist(estudiante);


		//recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
		@SuppressWarnings("unchecked")
		List<Object[]> Consulta3 = em.createQuery("SELECT e.Nombre, e.Apellido, e.Edad, e.Genero " +
				"FROM Estudiante e ORDER BY e.Edad").getResultList();
		Consulta3.forEach(d -> System.out.println(Arrays.toString(d)));

		//recuperar un estudiante, en base a su número de libreta universitaria.
		Estudiante e = em.find(Persona.class, 1);
		System.out.println(e);

		//recuperar todos los estudiantes, en base a su género.
		@SuppressWarnings("unchecked")
		List<Object[]> Consulta5 = em.createQuery("SELECT e.Nombre, e.Apellido, e.Edad, e.Genero " +
				"FROM Estudiante e WHERE e.Genero='Masculino'").getResultList();
		Consulta5.forEach(d -> System.out.println(Arrays.toString(d)));

		//recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
		@SuppressWarnings("unchecked")
		List<Object[]> Consulta6 = em.createQuery("SELECT c.Nombre, c.Anios FROM Carrera c " +
				"WHERE c.Estudiantes.size()>0 ORDER BY Estudiantes.size()").getResultList();
		Consulta6.forEach(d -> System.out.println(Arrays.toString(d)));
		em.getTransaction().commit();

		//recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
		@SuppressWarnings("unchecked")
		List<Object[]> Consulta7 = em.createQuery("SELECT e FROM Estudiante e JOIN e.Carreras c " +
				"WHERE c.Nombre='Ingenieria' AND e.CiudadResidencia='Necochea'").getResultList();
		Consulta7.forEach(d -> System.out.println(Arrays.toString(d)));

		//Generar un reporte de las carreras, que para cada carrera incluya información de los
		//inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
		//los años de manera cronológica.
		em.close();
		emf.close();
	}
}

}

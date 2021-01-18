package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Student;

@Stateless
public class StudentDAO {

	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;
	
	// Retourne la liste 
	public List<Student> query() {
		return em.createQuery("SELECT student FROM Student student").getResultList();
	}
	
	// Retourne un étudiant par son id
	public Student getById(int id) {
		return em.find(Student.class, id);
	}
	
	// Retourne un étudiant par son matricule
	public Student getByMatricule(String matricule) {
		// Requete préparé qui retourne un étudiant avec le bon matricule
		String stringRequest = "SELECT student from Student student "
				+ "where student.matricule=?1";
		TypedQuery<Student> query = em.createQuery(stringRequest, Student.class);
		query.setParameter(1, matricule);
		List<Student> students = query.getResultList();
		if (students.isEmpty()) {
			return null;
		} else {
			Student student = students.get(0);
			return student;
		}
	}

	// Crée un étudiant dans la base de données
	public Student create(Student o) {
		em.persist(o);
		return o;
	}
	
	// Crée en base de données toutes les étudiants présents dans la liste
	public List<Student> createAll(List<Student> students){
		for (Student student : students) {
			em.persist(student);
		}
		return students;
	}
	
	// Modifie un étudiant
	public Student update(Student o) {
		em.merge(o);
		return o;
	}
	
	// Supprime un étudiant s'il est présent en BD
	public boolean delete(int id) {
		Student studentToDelete = getById(id);
		if (studentToDelete != null) {
			em.remove(studentToDelete);
			return true;
		}
		return false;
	}
	
	// Supprime tous les étudiants présents en BD
	public boolean deleteAll() {
		List<Student> students = query();
		for (Student student : students) {
			em.remove(student);
		}
		return true;
	}
}

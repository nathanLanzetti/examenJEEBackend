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
	
	public List<Student> query() {
		return em.createQuery("SELECT student FROM Student student").getResultList();
	}
	
	public Student getById(int id) {
		return em.find(Student.class, id);
	}
	
	public Student getByMatricule(String matricule) {
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

	public Student create(Student o) {
		em.persist(o);
		return o;
	}
	
	public Student update(Student o) {
		em.merge(o);
		return o;
	}
	
	public boolean delete(int id) {
		Student studentToDelete = getById(id);
		if (studentToDelete != null) {
			em.remove(studentToDelete);
			return true;
		}
		return false;
	}
}

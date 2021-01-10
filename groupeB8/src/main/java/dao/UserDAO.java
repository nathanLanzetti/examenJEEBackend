package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.User;

@Stateless
public class UserDAO {

	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;
	
	public List<User> query() {
		return em.createQuery("SELECT user FROM User user").getResultList();
	}
	
	public User getById(int id) {
		return em.find(User.class, id);
	}
	
	public User logIn(String mail, String password) {
		String stringRequest = "SELECT u from User u "
				+ "where u.mail=?1 and u.password=?2";
		TypedQuery<User> query = em.createQuery(stringRequest, User.class);
		query.setParameter(1, mail);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			User user = users.get(0);
			return user;
		}
	}

	public User create(User o) {
		em.persist(o);
		return o;
	}
}

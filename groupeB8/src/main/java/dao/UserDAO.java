package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.User;
import util.PasswordHasher;

@Stateless
public class UserDAO {

	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;

	private PasswordHasher hasher = new PasswordHasher();
	
	// Retourne la liste de toutes les users présents en base de données
	public List<User> query() {
		return em.createQuery("SELECT user FROM User user").getResultList();
	}
	
	// Retourne l'utilisateur en fonction de son ID
	public User getById(int id) {
		return em.find(User.class, id);
	}
	
	// Renvoie un utilisateur si celui-ci existe
	public User logIn(String mail, String password) {
		// Préparation d'une requete préparé qui retourne
		// un utilisateur avec la combinaison email/mot de passe
		String stringRequest = "SELECT u from User u "
				+ "where u.email=?1 and u.password=?2";
		TypedQuery<User> query = em.createQuery(stringRequest, User.class);
		query.setParameter(1, mail);
		// Compare le mot de passe hashé (tous les mots de passe sont cryptés en BD)
		query.setParameter(2, hasher.hashWith256(password));
		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			User user = users.get(0);
			return user;
		}
	}

	// Crée un utilisateur
	public User create(User o) {
		// Cryptage du mot de passe
		o.setPassword(hasher.hashWith256(o.getPassword()));
		em.persist(o);
		return o;
	}
}

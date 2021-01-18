package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Activity;

@Stateless
public class ActivityDAO /*implements ICrudRepository<Activity>*/ {
	
	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;
	
	// Retourne une liste d'activit�
	public List<Activity> query() {
		return em.createQuery("SELECT activity FROM Activity activity").getResultList();
	}
	
	// Retourne une activit� en fonction d'un ID
	public Activity getById(int id) {
		return em.find(Activity.class, id);
	}
	
	// Retourne une activit� en fonction de son titre
	public Activity getByTitle(String title) {
		String stringRequest = "SELECT activity from Activity activity "
				+ "where activity.title=?1";
		TypedQuery<Activity> query = em.createQuery(stringRequest, Activity.class);
		query.setParameter(1, title);
		List<Activity> users = query.getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			Activity activity = users.get(0);
			return activity;
		}
	}

	// cr�e une activit� si elle n'est pas pr�sente dans la BD 
	public Activity create(Activity o) {
		if (getByTitle(o.getTitle()) == null) {
			em.persist(o);
			return o;
		}
		return null;
	}
	
	// modifie l'activit� pr�sente en BD
	public Activity update(Activity o) {
		em.merge(o);
		return o;
	}
	
	// supprime une activit� si elle pr�sente en BD
	public boolean delete(int id) {
		Activity activityToDelete = getById(id);
		if (activityToDelete != null) {
			em.remove(activityToDelete);
			return true;
		}
		return false;
	}
	
}

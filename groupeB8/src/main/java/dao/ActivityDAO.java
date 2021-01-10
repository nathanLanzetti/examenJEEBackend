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
	
	public List<Activity> query() {
		return em.createQuery("SELECT activity FROM Activity activity").getResultList();
	}
	
	public Activity getById(int id) {
		return em.find(Activity.class, id);
	}
	
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

	public Activity create(Activity o) {
		em.persist(o);
		return o;
	}
	
	public Activity update(Activity o) {
		em.merge(o);
		return o;
	}
	
	public boolean delete(int id) {
		Activity activityToDelete = getById(id);
		if (activityToDelete != null) {
			em.remove(activityToDelete);
			return true;
		}
		return false;
	}
	
}

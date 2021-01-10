package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Activity;

@Stateless
public class ActivityDAO /*implements ICrudRepository<Activity>*/ {
	
	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;

	public Activity create(Activity o) {
		em.persist(o);
		return o;
	}
	/*
	@Override
	public List<Activity> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	

	@Override
	public boolean update(Activity o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	*/
}

package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Student;
import entities.Unit;

@Stateless
public class UnitDAO {

	@PersistenceContext(unitName = "groupeB8")
	EntityManager em;
	
	public List<Unit> query() {
		return em.createQuery("SELECT unit FROM Unit unit").getResultList();
	}
	
	public Set<Unit> queryWithoutDuplicates() {
		//List<Unit> unitList = em.createQuery("SELECT unit FROM Unit unit").getResultList();
		Set<Unit> unitSet = new HashSet<Unit>(em.createQuery("SELECT unit FROM Unit unit").getResultList());
		return unitSet;
	}
	
	public Unit getById(int id) {
		return em.find(Unit.class, id);
	}
	
	public Unit getByCode(String code) {
		String stringRequest = "SELECT unit from Unit unit "
				+ "where unit.code=?1";
		TypedQuery<Unit> query = em.createQuery(stringRequest, Unit.class);
		query.setParameter(1, code);
		List<Unit> units = query.getResultList();
		if (units.isEmpty()) {
			return null;
		} else {
			Unit unit = units.get(0);
			return unit;
		}
	}

	public Unit create(Unit o) {
		em.persist(o);
		return o;
	}
	
	public List<Unit> createAll(List<Unit> units){
		for (Unit unit : units) {
			em.persist(unit);
		}
		return units;
	}
	
	public Unit update(Unit o) {
		em.merge(o);
		return o;
	}
	
	public boolean delete(int id) {
		Unit unitToDelete = getById(id);
		if (unitToDelete != null) {
			em.remove(unitToDelete);
			return true;
		}
		return false;
	}
	
	public boolean deleteAll() {
		List<Unit> units = query();
		for (Unit unit : units) {
			em.remove(unit);
		}
		return true;
	}
}

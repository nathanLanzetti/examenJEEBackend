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
	
	// Retourne la liste de toutes les unités présentes en base de données
	public List<Unit> query() {
		return em.createQuery("SELECT unit FROM Unit unit").getResultList();
	}
	
	// Retourne un set de toutes les unités présentes en base de données sans doublons
	// Les doublons sont vérifiés par l'implémentation de hashCode et equals
	// qui vérifie en fonction du code de l'UE
	public Set<Unit> queryWithoutDuplicates() {
		Set<Unit> unitSet = new HashSet<Unit>(em.createQuery("SELECT unit FROM Unit unit").getResultList());
		return unitSet;
	}
	
	// Retourne une unité en fonction de son id
	public Unit getById(int id) {
		return em.find(Unit.class, id);
	}
	
	// Retourne une unité en fonction de son code
	public Unit getByCode(String code) {
		// Création d'une requete préparé typé (Unit)
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

	// Crée une unité dans la base de données
	public Unit create(Unit o) {
		em.persist(o);
		return o;
	}
	
	// Crée en base de données toutes les unités présentes dans la liste
	public List<Unit> createAll(List<Unit> units){
		for (Unit unit : units) {
			em.persist(unit);
		}
		return units;
	}
	
	// Modifie l'unité présente en base de données
	public Unit update(Unit o) {
		em.merge(o);
		return o;
	}
	
	// Supprime l'unité présente en base de données
	public boolean delete(int id) {
		Unit unitToDelete = getById(id);
		if (unitToDelete != null) {
			em.remove(unitToDelete);
			return true;
		}
		return false;
	}
	
	// Supprime toutes les unités présentes en base de données
	public boolean deleteAll() {
		List<Unit> units = query();
		for (Unit unit : units) {
			em.remove(unit);
		}
		return true;
	}
}

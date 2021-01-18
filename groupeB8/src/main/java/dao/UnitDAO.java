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
	
	// Retourne la liste de toutes les unit�s pr�sentes en base de donn�es
	public List<Unit> query() {
		return em.createQuery("SELECT unit FROM Unit unit").getResultList();
	}
	
	// Retourne un set de toutes les unit�s pr�sentes en base de donn�es sans doublons
	// Les doublons sont v�rifi�s par l'impl�mentation de hashCode et equals
	// qui v�rifie en fonction du code de l'UE
	public Set<Unit> queryWithoutDuplicates() {
		Set<Unit> unitSet = new HashSet<Unit>(em.createQuery("SELECT unit FROM Unit unit").getResultList());
		return unitSet;
	}
	
	// Retourne une unit� en fonction de son id
	public Unit getById(int id) {
		return em.find(Unit.class, id);
	}
	
	// Retourne une unit� en fonction de son code
	public Unit getByCode(String code) {
		// Cr�ation d'une requete pr�par� typ� (Unit)
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

	// Cr�e une unit� dans la base de donn�es
	public Unit create(Unit o) {
		em.persist(o);
		return o;
	}
	
	// Cr�e en base de donn�es toutes les unit�s pr�sentes dans la liste
	public List<Unit> createAll(List<Unit> units){
		for (Unit unit : units) {
			em.persist(unit);
		}
		return units;
	}
	
	// Modifie l'unit� pr�sente en base de donn�es
	public Unit update(Unit o) {
		em.merge(o);
		return o;
	}
	
	// Supprime l'unit� pr�sente en base de donn�es
	public boolean delete(int id) {
		Unit unitToDelete = getById(id);
		if (unitToDelete != null) {
			em.remove(unitToDelete);
			return true;
		}
		return false;
	}
	
	// Supprime toutes les unit�s pr�sentes en base de donn�es
	public boolean deleteAll() {
		List<Unit> units = query();
		for (Unit unit : units) {
			em.remove(unit);
		}
		return true;
	}
}

package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String lastname;
	private String firstname;
	private Section section;
	private Bloc bloc;
	private String matricule;
	private String academicYear;
	private int creditsNumber;
	private List<Unit> units;
	private Map<String, Boolean> validatedUnits;
	private Map<String, Boolean> validatedActivities;
	
	public Student() {
		super();
	}
	
	public Student(Integer id, String lastname, String firstname, Section section, Bloc bloc, String matricule,
			String academicYear, int creditsNumber, List<Unit> units, Map<String, Boolean> validatedUnits,
			Map<String, Boolean> validatedActivities) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.section = section;
		this.bloc = bloc;
		this.matricule = matricule;
		this.academicYear = academicYear;
		this.creditsNumber = creditsNumber;
		this.units = units;
		this.validatedUnits = validatedUnits;
		this.validatedActivities = validatedActivities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Bloc getBloc() {
		return bloc;
	}

	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public int getCreditsNumber() {
		return creditsNumber;
	}

	public void setCreditsNumber(int creditsNumber) {
		this.creditsNumber = creditsNumber;
	}

	public List<Unit> getUnits() {
		return units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Map<String, Boolean> getValidatedUnits() {
		return validatedUnits;
	}

	public void setValidatedUnits(Map<String, Boolean> validatedUnits) {
		this.validatedUnits = validatedUnits;
	}

	public Map<String, Boolean> getValidatedActivities() {
		return validatedActivities;
	}

	public void setValidatedActivities(Map<String, Boolean> validatedActivities) {
		this.validatedActivities = validatedActivities;
	}
	
}

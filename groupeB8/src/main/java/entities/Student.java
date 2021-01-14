package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import enums.Bloc;
import enums.Section;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullname;
	@Enumerated(EnumType.ORDINAL)
	private Section section;
	@Enumerated(EnumType.ORDINAL)
	private Bloc bloc;
	private String matricule;
	private String academicYear;
	private int creditsNumber;
	@OneToMany
	private List<Unit> unitsGlobal;
	@OneToMany
	private List<Unit> unitsInPae;
	private List<String> validatedUnits;
	
	public Student() {
		super();
		this.unitsGlobal = new ArrayList<Unit>();
		this.unitsInPae = new ArrayList<Unit>();
		this.validatedUnits = new ArrayList<String>();
	}
	
	public Student(String fullname, Section section, Bloc bloc, String matricule, String academicYear,
			int creditsNumber, List<Unit> unitsGlobal, List<Unit> unitsInPae, List<String> validatedUnits) {
		super();
		this.fullname = fullname;
		this.section = section;
		this.bloc = bloc;
		this.matricule = matricule;
		this.academicYear = academicYear;
		this.creditsNumber = creditsNumber;
		this.unitsGlobal = unitsGlobal;
		this.unitsInPae = unitsInPae;
		this.validatedUnits = validatedUnits;
	}
	
	/*
	public Student(Integer id, String lastname, String firstname, Section section, Bloc bloc, String matricule,
			String academicYear, int creditsNumber, List<Unit> units) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.section = section;
		this.bloc = bloc;
		this.matricule = matricule;
		this.academicYear = academicYear;
		this.creditsNumber = creditsNumber;
		this.unitsGlobal = new ArrayList<Unit>(units);
	}
*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return unitsGlobal;
	}

	public void setUnits(List<Unit> units) {
		this.unitsGlobal = units;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public List<Unit> getUnitsInPae() {
		return unitsInPae;
	}



	public void setUnitsInPae(List<Unit> unitsInPae) {
		this.unitsInPae = unitsInPae;
	}



	public List<String> getValidatedUnits() {
		return validatedUnits;
	}



	public void setValidatedUnits(List<String> validatedUnits) {
		this.validatedUnits = validatedUnits;
	}
}

package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import enums.Bloc;
import enums.Section;

@Entity
public class Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Activity> activities;
	private String code;
	private int creditsNumber;
	private String title;
	private String academicYear;
	private Section section;
	private Bloc bloc;
	
	public Unit() {
		super();
		this.activities = new ArrayList<Activity>();
	}
	
	public Unit(List<Activity> activities, String code, int creditsNumber, String title, String academicYear,
			Section section, Bloc bloc) {
		super();
		this.activities = new ArrayList<Activity>(activities);
		this.code = code;
		this.creditsNumber = creditsNumber;
		this.title = title;
		this.academicYear = academicYear;
		this.section = section;
		this.bloc = bloc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCreditsNumber() {
		return creditsNumber;
	}

	public void setCreditsNumber(int creditsNumber) {
		this.creditsNumber = creditsNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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

	@Override
	public String toString() {
		return "Unit [id=" + id + ", activities=" + activities + ", code=" + code + ", creditsNumber=" + creditsNumber
				+ ", title=" + title + ", academicYear=" + academicYear + ", section=" + section + ", bloc=" + bloc
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	

}

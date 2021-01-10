package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private int creditsNumber;
	private Section section;
	private Bloc bloc;
	
	public Activity() {
		super();
	}
	
	public Activity(String title, int creditsNumber, Section section, Bloc bloc) {
		super();
		this.title = title;
		this.creditsNumber = creditsNumber;
		this.section = section;
		this.bloc = bloc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreditsNumber() {
		return creditsNumber;
	}

	public void setCreditsNumber(int creditsNumber) {
		this.creditsNumber = creditsNumber;
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
		return "Activity [id=" + id + ", title=" + title + ", creditsNumber=" + creditsNumber + ", section=" + section
				+ ", bloc=" + bloc + "]";
	}
	
	
}

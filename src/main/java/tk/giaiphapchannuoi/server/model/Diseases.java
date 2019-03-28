package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="diseases")
public class Diseases {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="agent")
	private String agent;
	
	@Column(name="symptom")
	private String symptom;
	
	@Column(name="diagnose")
	private String diagnose;
	
	@Column(name="treatment")
	private String treatment;
	
	@Column(name="note")
	private String note;
	
	@Column(name="images")
	private String images;

	public Diseases(
			String name, 
			String description,
			String agent, 
			String symptom, 
			String diagnose, 
			String treatment,
			String note, 
			String images) 
	{
		this.name = name;
		this.description = description;
		this.agent = agent;
		this.symptom = symptom;
		this.diagnose = diagnose;
		this.treatment = treatment;
		this.note = note;
		this.images = images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}

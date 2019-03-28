package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="medicines")
public class Medicines {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="medicine_code")
	private String medicine_code;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="use_for")
	private String use_for;
	
	@Column(name="guide")
	private String guide;
	
	@Column(name="description")
	private String description;

	public Medicines(
			String medicine_code,
			Integer type_id, 
			String name, 
			String use_for, 
			String guide,
			String description) 
	{
		this.medicine_code = medicine_code;
		this.type_id = type_id;
		this.name = name;
		this.use_for = use_for;
		this.guide = guide;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedicine_code() {
		return medicine_code;
	}

	public void setMedicine_code(String medicine_code) {
		this.medicine_code = medicine_code;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUse_for() {
		return use_for;
	}

	public void setUse_for(String use_for) {
		this.use_for = use_for;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

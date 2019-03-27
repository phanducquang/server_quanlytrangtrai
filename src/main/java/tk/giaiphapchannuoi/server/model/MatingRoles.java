package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="mating_roles")
public class MatingRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name="father_id")
	@ManyToOne
	private Integer father_id;
	
	@Column(name="mother_id")
	@ManyToOne
	private Integer mother_id;
	
	@Column(name="child_id")
	@ManyToOne
	private Integer child_id;
	
	@Column(name="birth_status_estimate")
	private Integer birth_status_estimate;
	
	@Column(name="description")
	private String description;

	public MatingRoles(
			Integer father_id, 
			Integer mother_id, 
			Integer child_id, 
			Integer birth_status_estimate,
			String description) 
	{
		this.father_id = father_id;
		this.mother_id = mother_id;
		this.child_id = child_id;
		this.birth_status_estimate = birth_status_estimate;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFather_id() {
		return father_id;
	}

	public void setFather_id(Integer father_id) {
		this.father_id = father_id;
	}

	public Integer getMother_id() {
		return mother_id;
	}

	public void setMother_id(Integer mother_id) {
		this.mother_id = mother_id;
	}

	public Integer getChild_id() {
		return child_id;
	}

	public void setChild_id(Integer child_id) {
		this.child_id = child_id;
	}

	public Integer getBirth_status_estimate() {
		return birth_status_estimate;
	}

	public void setBirth_status_estimate(Integer birth_status_estimate) {
		this.birth_status_estimate = birth_status_estimate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

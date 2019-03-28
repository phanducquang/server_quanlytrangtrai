package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="sections")
public class Sections {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="type_id")
	private Integer type_id;
	
	@Column(name="department_id")
	@ManyToOne
	private Integer department_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="founding")
	private Date founding;

	public Sections(
			Integer type_id, 
			Integer department_id, 
			String name, 
			String description, 
			Integer manager,
			Date founding) 
	{
		this.type_id = type_id;
		this.department_id = department_id;
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.founding = founding;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
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

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Date getFounding() {
		return founding;
	}

	public void setFounding(Date founding) {
		this.founding = founding;
	}
}

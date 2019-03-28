package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="farm_id")
	@ManyToOne
	private Integer farm_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="founding")
	private Date founding;

	public Departments(
			Integer farm_id, 
			String name, 
			String description, 
			Integer manager, 
			Date founding) 
	{
		this.farm_id = farm_id;
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

	public Integer getFarm_id() {
		return farm_id;
	}

	public void setFarm_id(Integer farm_id) {
		this.farm_id = farm_id;
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

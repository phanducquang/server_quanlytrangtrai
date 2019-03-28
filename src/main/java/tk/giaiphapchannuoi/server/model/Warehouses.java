package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="warehouses")
public class Warehouses {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="group_id")
	private Integer group_id;
	
	@Column(name="unit_id")
	private Integer unit_id;
	
	@Column(name="unit_type")
	private Integer unit_type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager")
	@ManyToOne
	private Integer manager;

	public Warehouses(
			Integer type_id, 
			Integer group_id, 
			Integer unit_id, 
			Integer unit_type, 
			String name,
			String description,
			Integer manager)
	{
		this.type_id = type_id;
		this.group_id = group_id;
		this.unit_id = unit_id;
		this.unit_type = unit_type;
		this.name = name;
		this.description = description;
		this.manager = manager;
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

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(Integer unit_id) {
		this.unit_id = unit_id;
	}

	public Integer getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(Integer unit_type) {
		this.unit_type = unit_type;
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
}

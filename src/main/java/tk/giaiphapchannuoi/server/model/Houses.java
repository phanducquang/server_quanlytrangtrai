package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="houses")
public class Houses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="section_id")
	@ManyToOne
	private Integer section_id;
	
	@Column(name="type_id")
	private Integer type_id;
	
	@Column(name="house_code")
	private String house_code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="position")
	private String position;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="founding")
	private Date founding;

	public Houses(
			Integer section_id, 
			Integer type_id, 
			String house_code, 
			String name, 
			String description,
			String position, 
			Integer manager, 
			Date founding) 
	{
		this.section_id = section_id;
		this.type_id = type_id;
		this.house_code = house_code;
		this.name = name;
		this.description = description;
		this.position = position;
		this.manager = manager;
		this.founding = founding;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSection_id() {
		return section_id;
	}

	public void setSection_id(Integer section_id) {
		this.section_id = section_id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getHouse_code() {
		return house_code;
	}

	public void setHouse_code(String house_code) {
		this.house_code = house_code;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="farms")
public class Farms {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="area")
	private Float area;
	
	@Column(name="total_pig")
	private Integer total_pig;
	
	@Column(name="founding")
	private Date founding;
	
	@Column(name="manager")
	@ManyToOne
	private Integer manager;
	
	@Column(name="description")
	private String description;

	public Farms(
			Integer type_id, 
			String address, 
			Float area, 
			Integer total_pig, 
			Date founding, 
			Integer manager,
			String description) 
	{
		this.type_id = type_id;
		this.address = address;
		this.area = area;
		this.total_pig = total_pig;
		this.founding = founding;
		this.manager = manager;
		this.description = description;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Integer getTotal_pig() {
		return total_pig;
	}

	public void setTotal_pig(Integer total_pig) {
		this.total_pig = total_pig;
	}

	public Date getFounding() {
		return founding;
	}

	public void setFounding(Date founding) {
		this.founding = founding;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="warehouses")
public class Warehouses extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id")
	private WarehouseType type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="manager")
	private Employees manager;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Warehouses() {
	}

	public Warehouses(WarehouseType type, String name, String description, Employees manager, Boolean delFlag) {
		this.type = type;
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WarehouseType getType() {
		return type;
	}

	public void setType(WarehouseType type) {
		this.type = type;
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

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

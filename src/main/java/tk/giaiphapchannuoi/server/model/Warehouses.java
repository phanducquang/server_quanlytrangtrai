package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="warehouses")
public class Warehouses extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id")
	private WarehouseType type;
	
	@Column(name="group_id")
	private Integer groupId;
	
	@Column(name="unit_id")
	private Integer unitId;
	
	@Column(name="unit_type")
	private Integer unitType;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager")
	private Integer manager;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Warehouses() {
	}

	public Warehouses(WarehouseType type, Integer groupId, Integer unitId, Integer unitType, String name, String description, Integer manager, Boolean delFlag) {
		this.type = type;
		this.groupId = groupId;
		this.unitId = unitId;
		this.unitType = unitType;
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getUnitType() {
		return unitType;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="sections")
public class Sections implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="type_id")
	private Integer typeId;

	@Column(name = "farm_id")
	private Integer farmId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="founding")
	private Date founding;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Sections() {
	}

	public Sections(Integer typeId, Integer farmId, String name, String description, Integer manager, Date founding, Boolean delFlag) {
		this.typeId = typeId;
		this.farmId = farmId;
		this.name = name;
		this.description = description;
		this.manager = manager;
		this.founding = founding;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getFarmId() {
		return farmId;
	}

	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="cages")
public class Cages extends Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="section_id")
	private Sections section;
	
//	@Column(name="type_id")
//	private Integer typeId;
	
	@Column(name="cage_code")
	private String houseCode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="position")
	private String position;
	
	@Column(name="status")
	private String status;
	
	@Column(name="founding")
	private Date founding;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Cages() {
	}

	public Cages(Sections section, String houseCode, String name, String description, String position, String status, Date founding, Boolean delFlag) {
		this.section = section;
		this.houseCode = houseCode;
		this.name = name;
		this.description = description;
		this.position = position;
		this.status = status;
		this.founding = founding;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sections getSection() {
		return section;
	}

	public void setSection(Sections section) {
		this.section = section;
	}

//	public Integer getTypeId() {
//		return typeId;
//	}
//
//	public void setTypeId(Integer typeId) {
//		this.typeId = typeId;
//	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

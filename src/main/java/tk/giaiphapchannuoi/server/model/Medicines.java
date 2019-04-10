package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="medicines")
public class Medicines implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="medicine_code")
	private String medicineCode;
	
	@Column(name="type_id")
	private Integer typeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="use_for")
	private String useFor;
	
	@Column(name="guide")
	private String guide;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Medicines() {
	}

	public Medicines(String medicineCode, Integer typeId, String name, String useFor, String guide, String description, Boolean delFlag) {
		this.medicineCode = medicineCode;
		this.typeId = typeId;
		this.name = name;
		this.useFor = useFor;
		this.guide = guide;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseFor() {
		return useFor;
	}

	public void setUseFor(String useFor) {
		this.useFor = useFor;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

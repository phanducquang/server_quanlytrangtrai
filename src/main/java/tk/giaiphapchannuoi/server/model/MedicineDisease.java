package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="medicice_disease")
public class MedicineDisease implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="medicine_id")
	private Integer medicineId;
	
	@Column(name="disease_id")
	private Integer diseaseId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MedicineDisease() {
	}

	public MedicineDisease(Integer medicineId, Integer diseaseId, Boolean delFlag) {
		this.medicineId = medicineId;
		this.diseaseId = diseaseId;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="medicine_disease")
public class MedicineDisease extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="medicine_id")
	private Medicines medicine;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="disease_id")
	private Diseases disease;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MedicineDisease() {
	}

	public MedicineDisease(Medicines medicine, Diseases disease, Boolean delFlag) {
		this.medicine = medicine;
		this.disease = disease;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medicines getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicines medicine) {
		this.medicine = medicine;
	}

	public Diseases getDisease() {
		return disease;
	}

	public void setDisease(Diseases disease) {
		this.disease = disease;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

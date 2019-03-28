package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="medicice_disease")
public class MedicineDisease {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="medicine_id")
	@ManyToOne
	private Integer medicine_id;
	
	@Column(name="disease_id")
	@ManyToOne
	private Integer disease_id;

	public MedicineDisease(Integer medicine_id, Integer disease_id) {
		super();
		this.medicine_id = medicine_id;
		this.disease_id = disease_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(Integer medicine_id) {
		this.medicine_id = medicine_id;
	}

	public Integer getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(Integer disease_id) {
		this.disease_id = disease_id;
	}
}

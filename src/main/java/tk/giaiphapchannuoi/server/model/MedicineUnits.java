package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="medicine_units")
public class MedicineUnits {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="description")
	private String description;
	
	@Column(name="base_unit")
	private Integer base_unit;

	public MedicineUnits(String name, Float quantity, String description, Integer base_unit) {
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.base_unit = base_unit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBase_unit() {
		return base_unit;
	}

	public void setBase_unit(Integer base_unit) {
		this.base_unit = base_unit;
	}
}

package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="feeds")
public class Feeds {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@ManyToOne
	private Integer id;
	
	@Column(name="object_type")
	private Integer object_type;
	
	@Column(name="object_id")
	@ManyToOne
	private Integer object_id;
	
	@Column(name="object_quantity")
	private Integer object_quantity;
	
	@Column(name="food_warehouse_id")
	@ManyToOne
	private Integer food_warehouse_id;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="total")
	private Float total;
	
	@Column(name="avg")
	private Float avg;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="employee_id")
	private Integer employee_id;
	
	@Column(name="description")
	private String description;

	public Feeds(
			Integer object_type, 
			Integer object_id, 
			Integer object_quantity, 
			Integer food_warehouse_id,
			Integer unit, 
			Float quantity, 
			Float total, 
			Float avg, 
			Date date, 
			Integer employee_id, 
			String description) 
	{
		this.object_type = object_type;
		this.object_id = object_id;
		this.object_quantity = object_quantity;
		this.food_warehouse_id = food_warehouse_id;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.avg = avg;
		this.date = date;
		this.employee_id = employee_id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getObject_type() {
		return object_type;
	}

	public void setObject_type(Integer object_type) {
		this.object_type = object_type;
	}

	public Integer getObject_id() {
		return object_id;
	}

	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
	}

	public Integer getObject_quantity() {
		return object_quantity;
	}

	public void setObject_quantity(Integer object_quantity) {
		this.object_quantity = object_quantity;
	}

	public Integer getFood_warehouse_id() {
		return food_warehouse_id;
	}

	public void setFood_warehouse_id(Integer food_warehouse_id) {
		this.food_warehouse_id = food_warehouse_id;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}

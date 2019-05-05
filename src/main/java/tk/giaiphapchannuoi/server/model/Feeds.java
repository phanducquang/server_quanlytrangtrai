package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="feeds")
public class Feeds extends Auditable implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="object_id")
	private Pigs pig;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="food_warehouse_id")
	private FoodWarehouse foodWarehouse;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="date")
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employees employee;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Feeds() {
	}

	public Feeds(Pigs pig, FoodWarehouse foodWarehouse, Integer unit, Float quantity, Date date, Employees employee, String description, Boolean delFlag) {
		this.pig = pig;
		this.foodWarehouse = foodWarehouse;
		this.unit = unit;
		this.quantity = quantity;
		this.date = date;
		this.employee = employee;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pigs getPig() {
		return pig;
	}

	public void setPig(Pigs pig) {
		this.pig = pig;
	}

	public FoodWarehouse getFoodWarehouse() {
		return foodWarehouse;
	}

	public void setFoodWarehouse(FoodWarehouse foodWarehouse) {
		this.foodWarehouse = foodWarehouse;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
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

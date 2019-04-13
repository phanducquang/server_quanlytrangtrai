package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="feeds")
public class Feeds extends Auditable implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="object_id")
	private Integer objectId;
	
	@Column(name="object_quantity")
	private Integer objectQuantity;
	
	@Column(name="food_warehouse_id")
	private Integer foodWarehouseId;
	
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
	private Integer employeeId;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Feeds() {
	}

	public Feeds(Integer objectType, Integer objectId, Integer objectQuantity, Integer foodWarehouseId, Integer unit, Float quantity, Float total, Float avg, Date date, Integer employeeId, String description, Boolean delFlag) {
		this.objectType = objectType;
		this.objectId = objectId;
		this.objectQuantity = objectQuantity;
		this.foodWarehouseId = foodWarehouseId;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.avg = avg;
		this.date = date;
		this.employeeId = employeeId;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getObjectType() {
		return objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public Integer getObjectQuantity() {
		return objectQuantity;
	}

	public void setObjectQuantity(Integer objectQuantity) {
		this.objectQuantity = objectQuantity;
	}

	public Integer getFoodWarehouseId() {
		return foodWarehouseId;
	}

	public void setFoodWarehouseId(Integer foodWarehouseId) {
		this.foodWarehouseId = foodWarehouseId;
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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

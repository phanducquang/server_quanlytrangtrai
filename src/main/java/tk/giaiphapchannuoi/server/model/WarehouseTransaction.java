package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="warehouse_transaction")
public class WarehouseTransaction {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="source_id")
	@ManyToOne
	private Integer source_id;
	
	@Column(name="source_manager")
	private Integer source_manager;
	
	@Column(name="destination_id")
	@ManyToOne
	private Integer destination_id;
	
	@Column(name="destination_manager")
	private Integer destination_manager;
	
	@Column(name="object_type")
	private Integer object_type;
	
	@Column(name="object_id")
	private Integer object_id;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="total")
	private Float total;
	
	@Column(name="date")
	private Date date;

	public WarehouseTransaction(
			Integer source_id, 
			Integer source_manager, 
			Integer destination_id,
			Integer destination_manager, 
			Integer object_type, 
			Integer object_id, 
			Integer unit, 
			Float quantity,
			Float total,
			Date date) 
	{
		this.source_id = source_id;
		this.source_manager = source_manager;
		this.destination_id = destination_id;
		this.destination_manager = destination_manager;
		this.object_type = object_type;
		this.object_id = object_id;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public Integer getSource_manager() {
		return source_manager;
	}

	public void setSource_manager(Integer source_manager) {
		this.source_manager = source_manager;
	}

	public Integer getDestination_id() {
		return destination_id;
	}

	public void setDestination_id(Integer destination_id) {
		this.destination_id = destination_id;
	}

	public Integer getDestination_manager() {
		return destination_manager;
	}

	public void setDestination_manager(Integer destination_manager) {
		this.destination_manager = destination_manager;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

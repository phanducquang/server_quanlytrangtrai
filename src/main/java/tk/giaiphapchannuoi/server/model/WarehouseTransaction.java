package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="warehouse_transaction")
public class WarehouseTransaction implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="source_id")
	private Integer sourceId;
	
	@Column(name="source_manager")
	private Integer sourceManager;
	
	@Column(name="destination_id")
	private Integer destinationId;
	
	@Column(name="destination_manager")
	private Integer destinationManager;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="object_id")
	private Integer objectId;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="total")
	private Float total;
	
	@Column(name="date")
	private Date date;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public WarehouseTransaction() {
	}

	public WarehouseTransaction(Integer sourceId, Integer sourceManager, Integer destinationId, Integer destinationManager, Integer objectType, Integer objectId, Integer unit, Float quantity, Float total, Date date, Boolean delFlag) {
		this.sourceId = sourceId;
		this.sourceManager = sourceManager;
		this.destinationId = destinationId;
		this.destinationManager = destinationManager;
		this.objectType = objectType;
		this.objectId = objectId;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.date = date;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getSourceManager() {
		return sourceManager;
	}

	public void setSourceManager(Integer sourceManager) {
		this.sourceManager = sourceManager;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public Integer getDestinationManager() {
		return destinationManager;
	}

	public void setDestinationManager(Integer destinationManager) {
		this.destinationManager = destinationManager;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

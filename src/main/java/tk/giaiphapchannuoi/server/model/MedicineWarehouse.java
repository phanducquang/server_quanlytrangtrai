package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="medicine_warehouse")
public class MedicineWarehouse extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="warehouse_id")
	private Integer warehouseId;
	
	@Column(name="medicine_id")
	private Integer medicineId;
	
	@Column(name="invoice_id")
	private Integer invoiceId;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name="import_date")
	private Date importDate;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="total")
	private Float total;
	
	@Column(name="used")
	private Float used;
	
	@Column(name="remain")
	private Float remain;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="mfg_date")
	private Date mfgDate;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	@Column(name="type_use")
	private String typeUse;
	
	@Column(name="images")
	private String images;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MedicineWarehouse() {
	}

	public MedicineWarehouse(Integer warehouseId, Integer medicineId, Integer invoiceId, Integer parentId, Date importDate, Integer unit, Float quantity, Float total, Float used, Float remain, String manufacturer, Date mfgDate, Date expiryDate, String typeUse, String images, Boolean delFlag) {
		this.warehouseId = warehouseId;
		this.medicineId = medicineId;
		this.invoiceId = invoiceId;
		this.parentId = parentId;
		this.importDate = importDate;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.used = used;
		this.remain = remain;
		this.manufacturer = manufacturer;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.typeUse = typeUse;
		this.images = images;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
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

	public Float getUsed() {
		return used;
	}

	public void setUsed(Float used) {
		this.used = used;
	}

	public Float getRemain() {
		return remain;
	}

	public void setRemain(Float remain) {
		this.remain = remain;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTypeUse() {
		return typeUse;
	}

	public void setTypeUse(String typeUse) {
		this.typeUse = typeUse;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

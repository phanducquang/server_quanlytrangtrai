package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="food_warehouse")
public class FoodWarehouse extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="warehouse_id")
	private Warehouses warehouse;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="food_id")
	private Foods food;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="invoice_id")
//	private InvoicesProduct invoice;

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
	
	@Column(name="images")
	private String images;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public FoodWarehouse() {
	}

//	public FoodWarehouse(Warehouses warehouse, Foods food, InvoicesProduct invoice, Integer parentId, Date importDate, Integer unit, Float quantity, Float total, Float used, Float remain, String manufacturer, Date mfgDate, Date expiryDate, String images, Boolean delFlag) {
//		this.warehouse = warehouse;
//		this.food = food;
//		this.invoice = invoice;
//		this.parentId = parentId;
//		this.importDate = importDate;
//		this.unit = unit;
//		this.quantity = quantity;
//		this.total = total;
//		this.used = used;
//		this.remain = remain;
//		this.manufacturer = manufacturer;
//		this.mfgDate = mfgDate;
//		this.expiryDate = expiryDate;
//		this.images = images;
//		this.delFlag = delFlag;
//	}


	public FoodWarehouse(Warehouses warehouse, Foods food, Integer invoiceId, Integer parentId, Date importDate, Integer unit, Float quantity, Float total, Float used, Float remain, String manufacturer, Date mfgDate, Date expiryDate, String images, Boolean delFlag) {
		this.warehouse = warehouse;
		this.food = food;
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
		this.images = images;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Warehouses getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouses warehouse) {
		this.warehouse = warehouse;
	}

	public Foods getFood() {
		return food;
	}

	public void setFood(Foods food) {
		this.food = food;
	}

//	public InvoicesProduct getInvoice() {
//		return invoice;
//	}
//
//	public void setInvoice(InvoicesProduct invoice) {
//		this.invoice = invoice;
//	}

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

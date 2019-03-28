package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="food_warehouse")
public class FoodWarehouse {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="warehouse_id")
	@ManyToOne
	private Integer warehouse_id;
	
	@Column(name="food_id")
	@ManyToOne
	private Integer food_id;
	
	@Column(name="invoice_id")
	private Integer invoice_id;
	
	@Column(name="invoice_no")
	private String invoice_no;
	
	@Column(name="parent_id")
	private Integer parent_id;
	
	@Column(name="import_date")
	private Date import_date;
	
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
	private Date mfg_date;
	
	@Column(name="expiry_date")
	private Date expiry_date;
	
	@Column(name="images")
	private String images;

	public FoodWarehouse(
			Integer warehouse_id, 
			Integer food_id, 
			Integer invoice_id, 
			String invoice_no,
			Integer parent_id, 
			Date import_date, 
			Integer unit, 
			Float quantity, 
			Float total, 
			Float used, 
			Float remain,
			String manufacturer, 
			Date mfg_date, 
			Date expiry_date, 
			String images) 
	{
		this.warehouse_id = warehouse_id;
		this.food_id = food_id;
		this.invoice_id = invoice_id;
		this.invoice_no = invoice_no;
		this.parent_id = parent_id;
		this.import_date = import_date;
		this.unit = unit;
		this.quantity = quantity;
		this.total = total;
		this.used = used;
		this.remain = remain;
		this.manufacturer = manufacturer;
		this.mfg_date = mfg_date;
		this.expiry_date = expiry_date;
		this.images = images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public Integer getFood_id() {
		return food_id;
	}

	public void setFood_id(Integer food_id) {
		this.food_id = food_id;
	}

	public Integer getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Date getImport_date() {
		return import_date;
	}

	public void setImport_date(Date import_date) {
		this.import_date = import_date;
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

	public Date getMfg_date() {
		return mfg_date;
	}

	public void setMfg_date(Date mfg_date) {
		this.mfg_date = mfg_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}

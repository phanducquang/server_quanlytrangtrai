package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="invoices_product")
public class InvoicesProduct {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="invoice_no")
	private String invoice_no;
	
	@Column(name="source_id")
	@ManyToOne
	private Integer source_id;
	
	@Column(name="source_manager")
	@ManyToOne
	private Integer source_manager;
	
	@Column(name="source_manager_name")
	private String source_manager_name;
	
	@Column(name="destination_id")
	@ManyToOne
	private Integer destination_id;
	
	@Column(name="destination_manager")
	@ManyToOne
	private Integer destination_manager;
	
	@Column(name="destination_manager_name")
	private String destination_manager_name;
	
	@Column(name="warehouse_id")
	private Integer warehouse_id;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="import_date")
	private Date import_date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="create_by")
	private Integer create_by;
	
	@Column(name="update_by")
	private Integer update_by;

	public InvoicesProduct(
			String invoice_no, 
			Integer source_id, 
			Integer source_manager, 
			String source_manager_name,
			Integer destination_id, 
			Integer destination_manager, 
			String destination_manager_name, 
			Integer warehouse_id,
			Integer quantity, 
			Float price, 
			Date import_date, 
			String description, 
			Integer create_by, 
			Integer update_by) 
	{
		this.invoice_no = invoice_no;
		this.source_id = source_id;
		this.source_manager = source_manager;
		this.source_manager_name = source_manager_name;
		this.destination_id = destination_id;
		this.destination_manager = destination_manager;
		this.destination_manager_name = destination_manager_name;
		this.warehouse_id = warehouse_id;
		this.quantity = quantity;
		this.price = price;
		this.import_date = import_date;
		this.description = description;
		this.create_by = create_by;
		this.update_by = update_by;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
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

	public String getSource_manager_name() {
		return source_manager_name;
	}

	public void setSource_manager_name(String source_manager_name) {
		this.source_manager_name = source_manager_name;
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

	public String getDestination_manager_name() {
		return destination_manager_name;
	}

	public void setDestination_manager_name(String destination_manager_name) {
		this.destination_manager_name = destination_manager_name;
	}

	public Integer getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getImport_date() {
		return import_date;
	}

	public void setImport_date(Date import_date) {
		this.import_date = import_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreate_by() {
		return create_by;
	}

	public void setCreate_by(Integer create_by) {
		this.create_by = create_by;
	}

	public Integer getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(Integer update_by) {
		this.update_by = update_by;
	}
}

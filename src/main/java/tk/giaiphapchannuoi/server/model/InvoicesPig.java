package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="invoices_pig")
public class InvoicesPig {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="invoice_no")
	private String invoice_no;
	
	@Column(name="invoice_type")
	private Integer invoice_type;
	
	@Column(name="source_id")
	private Integer source_id;
	
	@Column(name="source_manager")
	private Integer source_manager;
	
	@Column(name="source_manager_name")
	private String source_manager_name;
	
	@Column(name="source_address")
	private String source_address;
	
	@Column(name="destination_id")
	private Integer destination_id;
	
	@Column(name="destination_manager")
	private Integer destination_manager;
	
	@Column(name="destination_manager_name")
	private String destination_manager_name;
	
	@Column(name="destination_address")
	private String destination_address;
	
	@Column(name="vehicle_number")
	private String vehicle_number;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_price")
	private Float unit_price;
	
	@Column(name="total_weight")
	private Float total_weight;
	
	@Column(name="total_price")
	private Float total_price;
	
	@Column(name="import_date")
	private Date import_date;
	
	@Column(name="export_date")
	private Date export_date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="create_by")
	private Integer create_by;
	
	@Column(name="update_by")
	private Integer update_by;

	public InvoicesPig(
			String invoice_no, 
			Integer invoice_type, 
			Integer source_id, 
			Integer source_manager,
			String source_manager_name, 
			String source_address, 
			Integer destination_id, 
			Integer destination_manager,
			String destination_manager_name, 
			String destination_address, 
			String vehicle_number, 
			Integer quantity,
			Float unit_price, 
			Float total_weight, 
			Float total_price, 
			Date import_date, 
			Date export_date,
			String description, 
			Integer create_by, 
			Integer update_by) 
	{
		this.invoice_no = invoice_no;
		this.invoice_type = invoice_type;
		this.source_id = source_id;
		this.source_manager = source_manager;
		this.source_manager_name = source_manager_name;
		this.source_address = source_address;
		this.destination_id = destination_id;
		this.destination_manager = destination_manager;
		this.destination_manager_name = destination_manager_name;
		this.destination_address = destination_address;
		this.vehicle_number = vehicle_number;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.total_weight = total_weight;
		this.total_price = total_price;
		this.import_date = import_date;
		this.export_date = export_date;
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

	public Integer getInvoice_type() {
		return invoice_type;
	}

	public void setInvoice_type(Integer invoice_type) {
		this.invoice_type = invoice_type;
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

	public String getSource_address() {
		return source_address;
	}

	public void setSource_address(String source_address) {
		this.source_address = source_address;
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

	public String getDestination_address() {
		return destination_address;
	}

	public void setDestination_address(String destination_address) {
		this.destination_address = destination_address;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Float unit_price) {
		this.unit_price = unit_price;
	}

	public Float getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(Float total_weight) {
		this.total_weight = total_weight;
	}

	public Float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Float total_price) {
		this.total_price = total_price;
	}

	public Date getImport_date() {
		return import_date;
	}

	public void setImport_date(Date import_date) {
		this.import_date = import_date;
	}

	public Date getExport_date() {
		return export_date;
	}

	public void setExport_date(Date export_date) {
		this.export_date = export_date;
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

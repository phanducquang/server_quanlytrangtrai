package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="invoices_pig")
public class InvoicesPig extends Auditable implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="invoice_type")
	private String invoiceType;
	
	@Column(name="source_id")
	private Integer sourceId;
	
	@Column(name="source_manager")
	private Integer sourceManager;
	
	@Column(name="source_manager_name")
	private String sourceManagerName;
	
	@Column(name="source_address")
	private String sourceAddress;
	
	@Column(name="destination_id")
	private Integer destinationId;
	
	@Column(name="destination_manager")
	private Integer destinationManager;
	
	@Column(name="destination_manager_name")
	private String destinationManagerName;
	
	@Column(name="destination_address")
	private String destinationAddress;
	
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="unit_price")
	private Double unitPrice;
	
	@Column(name="total_weight")
	private Float totalWeight;
	
	@Column(name="total_price")
	private Double totalPrice;
	
	@Column(name="import_date")
	private Date importDate;
	
	@Column(name="export_date")
	private Date exportDate;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employees employee;

	public InvoicesPig() {
	}

	public InvoicesPig(String invoiceNo, String invoiceType, Integer sourceId, Integer sourceManager, String sourceManagerName, String sourceAddress, Integer destinationId, Integer destinationManager, String destinationManagerName, String destinationAddress, String vehicleNumber, Integer quantity, Double unitPrice, Float totalWeight, Double totalPrice, Date importDate, Date exportDate, String description, Boolean delFlag, String status, Employees employee) {
		this.invoiceNo = invoiceNo;
		this.invoiceType = invoiceType;
		this.sourceId = sourceId;
		this.sourceManager = sourceManager;
		this.sourceManagerName = sourceManagerName;
		this.sourceAddress = sourceAddress;
		this.destinationId = destinationId;
		this.destinationManager = destinationManager;
		this.destinationManagerName = destinationManagerName;
		this.destinationAddress = destinationAddress;
		this.vehicleNumber = vehicleNumber;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalWeight = totalWeight;
		this.totalPrice = totalPrice;
		this.importDate = importDate;
		this.exportDate = exportDate;
		this.description = description;
		this.delFlag = delFlag;
		this.status = status;
		this.employee = employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
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

	public String getSourceManagerName() {
		return sourceManagerName;
	}

	public void setSourceManagerName(String sourceManagerName) {
		this.sourceManagerName = sourceManagerName;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
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

	public String getDestinationManagerName() {
		return destinationManagerName;
	}

	public void setDestinationManagerName(String destinationManagerName) {
		this.destinationManagerName = destinationManagerName;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Float totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Date getExportDate() {
		return exportDate;
	}

	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
}

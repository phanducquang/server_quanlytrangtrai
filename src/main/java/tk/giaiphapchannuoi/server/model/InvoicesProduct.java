package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="invoices_product")
public class InvoicesProduct implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="source_id")
	private Integer sourceId;
	
	@Column(name="source_manager")
	private Integer sourceManager;
	
	@Column(name="source_manager_name")
	private String sourceManagerName;
	
	@Column(name="destination_id")
	private Integer destinationId;
	
	@Column(name="destination_manager")
	private Integer destinationManager;
	
	@Column(name="destination_manager_name")
	private String destinationManagerName;
	
	@Column(name="warehouse_id")
	private Integer warehouseId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="import_date")
	private Date importDate;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public InvoicesProduct() {
	}

	public InvoicesProduct(String invoiceNo, Integer sourceId, Integer sourceManager, String sourceManagerName, Integer destinationId, Integer destinationManager, String destinationManagerName, Integer warehouseId, Integer quantity, Float price, Date importDate, String description, Boolean delFlag) {
		this.invoiceNo = invoiceNo;
		this.sourceId = sourceId;
		this.sourceManager = sourceManager;
		this.sourceManagerName = sourceManagerName;
		this.destinationId = destinationId;
		this.destinationManager = destinationManager;
		this.destinationManagerName = destinationManagerName;
		this.warehouseId = warehouseId;
		this.quantity = quantity;
		this.price = price;
		this.importDate = importDate;
		this.description = description;
		this.delFlag = delFlag;
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

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
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

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
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

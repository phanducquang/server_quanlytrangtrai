package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="invoices_product")
public class InvoicesProduct extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name = "type")
	private String type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="source_id")
	private Partners source;
	
	@Column(name="source_manager_name")
	private String sourceManagerName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="destination_id")
	private Farms destination;
	
	@Column(name="destination_manager")
	private Integer destinationManager;
	
	@Column(name="destination_manager_name")
	private String destinationManagerName;
	
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

	public InvoicesProduct(String invoiceNo, String type, Partners source, String sourceManagerName, Farms destination, Integer destinationManager, String destinationManagerName, Float price, Date importDate, String description, Boolean delFlag) {
		this.invoiceNo = invoiceNo;
		this.type = type;
		this.source = source;
		this.sourceManagerName = sourceManagerName;
		this.destination = destination;
		this.destinationManager = destinationManager;
		this.destinationManagerName = destinationManagerName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Partners getSource() {
		return source;
	}

	public void setSource(Partners source) {
		this.source = source;
	}

	public String getSourceManagerName() {
		return sourceManagerName;
	}

	public void setSourceManagerName(String sourceManagerName) {
		this.sourceManagerName = sourceManagerName;
	}

	public Farms getDestination() {
		return destination;
	}

	public void setDestination(Farms destination) {
		this.destination = destination;
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

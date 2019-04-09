package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="invoice_pig_detail")
public class InvoicePigDetail implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="invoice_id")
	private Integer invoiceId;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="object_id")
	private Integer objectId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public InvoicePigDetail() {
	}

	public InvoicePigDetail(Integer invoiceId, Integer objectType, Integer objectId, Boolean delFlag) {
		this.invoiceId = invoiceId;
		this.objectType = objectType;
		this.objectId = objectId;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="invoice_pig_detail")
public class InvoicePigDetail extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_id")
	private InvoicesPig invoice;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="object_id")
	private Integer objectId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public InvoicePigDetail() {
	}

	public InvoicePigDetail(InvoicesPig invoice, Integer objectType, Integer objectId, Boolean delFlag) {
		this.invoice = invoice;
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

	public InvoicesPig getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoicesPig invoice) {
		this.invoice = invoice;
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

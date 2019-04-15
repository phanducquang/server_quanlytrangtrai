package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="invoices_product_detail")
public class InvoicesProductDetail extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_id")
	private InvoicesProduct invoice;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="object_id")
	private Integer objectId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public InvoicesProductDetail() {
	}

	public InvoicesProductDetail(InvoicesProduct invoice, Integer objectType, Integer objectId, Boolean delFlag) {
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

	public InvoicesProduct getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoicesProduct invoice) {
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

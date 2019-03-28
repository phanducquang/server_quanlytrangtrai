package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="invoices_product_detail")
public class InvoicesProductDetail {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="invoice_id")
	@ManyToOne
	private Integer invoice_id;
	
	@Column(name="object_type")
	private Integer object_type;
	
	@Column(name="object_id")
	private Integer object_id;
	
	@Column(name="create_by")
	private Integer create_by;
	
	@Column(name="update_by")
	private Integer update_by;

	public InvoicesProductDetail(
			Integer invoice_id, 
			Integer object_type, 
			Integer object_id, 
			Integer create_by,
			Integer update_by) 
	{
		this.invoice_id = invoice_id;
		this.object_type = object_type;
		this.object_id = object_id;
		this.create_by = create_by;
		this.update_by = update_by;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Integer invoice_id) {
		this.invoice_id = invoice_id;
	}

	public Integer getObject_type() {
		return object_type;
	}

	public void setObject_type(Integer object_type) {
		this.object_type = object_type;
	}

	public Integer getObject_id() {
		return object_id;
	}

	public void setObject_id(Integer object_id) {
		this.object_id = object_id;
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

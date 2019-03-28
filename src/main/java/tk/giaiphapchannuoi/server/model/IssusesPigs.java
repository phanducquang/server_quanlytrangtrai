package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issues_pigs")
public class IssusesPigs {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="pig_id")
	@ManyToOne
	private Integer pig_id;
	
	@Column(name="issue_id")
	@ManyToOne
	private Integer issue_id;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="employee_id")
	@ManyToOne
	private Integer employee_id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="images")
	private String images;
	
	@Column(name="status")
	private Integer status;

	public IssusesPigs(
			Date date, 
			Integer pig_id, 
			Integer issue_id, 
			Integer quantity, 
			Integer employee_id,
			String description, 
			String images, 
			Integer status) 
	{
		this.date = date;
		this.pig_id = pig_id;
		this.issue_id = issue_id;
		this.quantity = quantity;
		this.employee_id = employee_id;
		this.description = description;
		this.images = images;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPig_id() {
		return pig_id;
	}

	public void setPig_id(Integer pig_id) {
		this.pig_id = pig_id;
	}

	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}

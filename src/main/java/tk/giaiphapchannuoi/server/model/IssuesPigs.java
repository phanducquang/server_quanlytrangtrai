package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issues_pigs")
public class IssuesPigs extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pig_id")
	private Pigs pig;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="issue_id")
	private Issues issue;
	
	@Column(name="quantity")
	private Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employees employee;
	
	@Column(name="description")
	private String description;
	
	@Column(name="images")
	private String images;
	
	@Column(name="status")
	private Integer status;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public IssuesPigs() {
	}

	public IssuesPigs(Date date, Pigs pig, Issues issue, Integer quantity, Employees employee, String description, String images, Integer status, Boolean delFlag) {
		this.date = date;
		this.pig = pig;
		this.issue = issue;
		this.quantity = quantity;
		this.employee = employee;
		this.description = description;
		this.images = images;
		this.status = status;
		this.delFlag = delFlag;
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

	public Pigs getPig() {
		return pig;
	}

	public void setPig(Pigs pig) {
		this.pig = pig;
	}

	public Issues getIssue() {
		return issue;
	}

	public void setIssue(Issues issue) {
		this.issue = issue;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issues_pigs")
public class IssuesPigs implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="pig_id")
	private Integer pigId;
	
	@Column(name="issue_id")
	private Integer issueId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
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

	public IssuesPigs(Date date, Integer pigId, Integer issueId, Integer quantity, Integer employeeId, String description, String images, Integer status, Boolean delFlag) {
		this.date = date;
		this.pigId = pigId;
		this.issueId = issueId;
		this.quantity = quantity;
		this.employeeId = employeeId;
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

	public Integer getPigId() {
		return pigId;
	}

	public void setPigId(Integer pigId) {
		this.pigId = pigId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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

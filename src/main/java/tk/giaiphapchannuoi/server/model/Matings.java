package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="matings")
public class Matings implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="mother_id")
	private Integer motherId;
	
	@Column(name="father_id")
	private Integer fatherId;
	
	@Column(name="sperm_id")
	private Integer spermId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer logId;
	
	@Column(name="child_id")
	private Integer childid;
	
	@Column(name="birth_estimate")
	private Date birthEstimate;
	
	@Column(name="birth_status_estimate")
	private Integer birthStatusEstimate;
	
	@Column(name="employee_id")
	private Integer employeeId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Matings() {
	}

	public Matings(Integer motherId, Integer fatherId, Integer spermId, Date date, Integer logId, Integer childid, Date birthEstimate, Integer birthStatusEstimate, Integer employeeId, Boolean delFlag) {
		this.motherId = motherId;
		this.fatherId = fatherId;
		this.spermId = spermId;
		this.date = date;
		this.logId = logId;
		this.childid = childid;
		this.birthEstimate = birthEstimate;
		this.birthStatusEstimate = birthStatusEstimate;
		this.employeeId = employeeId;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMotherId() {
		return motherId;
	}

	public void setMotherId(Integer motherId) {
		this.motherId = motherId;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Integer getSpermId() {
		return spermId;
	}

	public void setSpermId(Integer spermId) {
		this.spermId = spermId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getChildid() {
		return childid;
	}

	public void setChildid(Integer childid) {
		this.childid = childid;
	}

	public Date getBirthEstimate() {
		return birthEstimate;
	}

	public void setBirthEstimate(Date birthEstimate) {
		this.birthEstimate = birthEstimate;
	}

	public Integer getBirthStatusEstimate() {
		return birthStatusEstimate;
	}

	public void setBirthStatusEstimate(Integer birthStatusEstimate) {
		this.birthStatusEstimate = birthStatusEstimate;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

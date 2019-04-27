package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="matings")
public class Matings extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mother_id")
	private Pigs mother;
	
	@Column(name="father_id")
	private Integer fatherId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sperm_id")
	private Sperm sperm;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer logId;
	
	@Column(name="child_id")
	private Integer childId;
	
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

	public Matings(Pigs mother, Integer fatherId, Sperm sperm, Date date, Integer logId, Integer childId, Date birthEstimate, Integer birthStatusEstimate, Integer employeeId, Boolean delFlag) {
		this.mother = mother;
		this.fatherId = fatherId;
		this.sperm = sperm;
		this.date = date;
		this.logId = logId;
		this.childId = childId;
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

	public Pigs getMother() {
		return mother;
	}

	public void setMother(Pigs mother) {
		this.mother = mother;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Sperm getSperm() {
		return sperm;
	}

	public void setSperm(Sperm sperm) {
		this.sperm = sperm;
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

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
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

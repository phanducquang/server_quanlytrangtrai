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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="father_id")
	private Pigs father;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="sperm_id")
//	private Sperm sperm;
	
	@Column(name="date")
	private Date date;
	
//	@Column(name="log_id")
//	private Integer logId;
	
	@Column(name="child_id")
	private Integer childId;
	
	@Column(name="birth_estimate")
	private Date birthEstimate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="employee_id")
	private Integer employeeId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Matings() {
	}

	public Matings(Pigs mother, Pigs father, Date date, Integer childId, Date birthEstimate, String status, Integer employeeId, Boolean delFlag) {
		this.mother = mother;
		this.father = father;
		this.date = date;
		this.childId = childId;
		this.birthEstimate = birthEstimate;
		this.status = status;
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

	public Pigs getFather() {
		return father;
	}

	public void setFather(Pigs father) {
		this.father = father;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

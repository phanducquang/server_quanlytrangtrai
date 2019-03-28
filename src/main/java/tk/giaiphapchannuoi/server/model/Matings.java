package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="matings")
public class Matings {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="mother_id")
	@ManyToOne
	private Integer mother_id;
	
	@Column(name="father_id")
	@ManyToOne
	private Integer father_id;
	
	@Column(name="sperm_id")
	@ManyToOne
	private Integer sperm_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer log_id;
	
	@Column(name="child_id")
	private Integer child_id;
	
	@Column(name="birth_estimate")
	private Date birth_estimate;
	
	@Column(name="birth_status_estimate")
	private Integer birth_status_estimate;
	
	@Column(name="employee_id")
	@ManyToOne
	private Integer employee_id;

	public Matings(
			Integer mother_id, 
			Integer father_id, 
			Integer sperm_id, 
			Date date, 
			Integer log_id, 
			Integer child_id,
			Date birth_estimate, 
			Integer birth_status_estimate, 
			Integer employee_id) 
	{
		this.mother_id = mother_id;
		this.father_id = father_id;
		this.sperm_id = sperm_id;
		this.date = date;
		this.log_id = log_id;
		this.child_id = child_id;
		this.birth_estimate = birth_estimate;
		this.birth_status_estimate = birth_status_estimate;
		this.employee_id = employee_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMother_id() {
		return mother_id;
	}

	public void setMother_id(Integer mother_id) {
		this.mother_id = mother_id;
	}

	public Integer getFather_id() {
		return father_id;
	}

	public void setFather_id(Integer father_id) {
		this.father_id = father_id;
	}

	public Integer getSperm_id() {
		return sperm_id;
	}

	public void setSperm_id(Integer sperm_id) {
		this.sperm_id = sperm_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLog_id() {
		return log_id;
	}

	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}

	public Integer getChild_id() {
		return child_id;
	}

	public void setChild_id(Integer child_id) {
		this.child_id = child_id;
	}

	public Date getBirth_estimate() {
		return birth_estimate;
	}

	public void setBirth_estimate(Date birth_estimate) {
		this.birth_estimate = birth_estimate;
	}

	public Integer getBirth_status_estimate() {
		return birth_status_estimate;
	}

	public void setBirth_status_estimate(Integer birth_status_estimate) {
		this.birth_status_estimate = birth_status_estimate;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	
	
}

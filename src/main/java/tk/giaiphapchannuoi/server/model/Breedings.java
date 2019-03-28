package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="breedings")
public class Breedings {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="pig_id")
	@ManyToOne
	private Integer pig_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer log_id;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="breeding_count")
	private Integer breeding_count;
	
	@Column(name="breeding_next")
	private Date breeding_next;
	
	@Column(name="mating_estimate")
	private Date mating_estimate;
	
	@Column(name="mating_real")
	private Date mating_real;

	public Breedings(
			Integer pig_id, 
			Date date, 
			Integer log_id, 
			Integer type_id, 
			String description,
			Integer breeding_count, 
			Date breeding_next, 
			Date mating_estimate, 
			Date mating_real) 
	{
		this.pig_id = pig_id;
		this.date = date;
		this.log_id = log_id;
		this.type_id = type_id;
		this.description = description;
		this.breeding_count = breeding_count;
		this.breeding_next = breeding_next;
		this.mating_estimate = mating_estimate;
		this.mating_real = mating_real;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPig_id() {
		return pig_id;
	}

	public void setPig_id(Integer pig_id) {
		this.pig_id = pig_id;
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

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBreeding_count() {
		return breeding_count;
	}

	public void setBreeding_count(Integer breeding_count) {
		this.breeding_count = breeding_count;
	}

	public Date getBreeding_next() {
		return breeding_next;
	}

	public void setBreeding_next(Date breeding_next) {
		this.breeding_next = breeding_next;
	}

	public Date getMating_estimate() {
		return mating_estimate;
	}

	public void setMating_estimate(Date mating_estimate) {
		this.mating_estimate = mating_estimate;
	}

	public Date getMating_real() {
		return mating_real;
	}

	public void setMating_real(Date mating_real) {
		this.mating_real = mating_real;
	}
	
	
}

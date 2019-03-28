package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="sperm")
public class Sperm {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="pig_id")
	@ManyToOne
	private Integer pig_id;
	
	@Column(name="sperm_count")
	private Integer sperm_count;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="volume")
	private Float volume;
	
	@Column(name="doses")
	private Integer doses;
	
	@Column(name="used")
	private Integer used;
	
	@Column(name="activity")
	private Float activity;
	
	@Column(name="c")
	private Float c;
	
	@Column(name="life_avg")
	private Float life_avg;
	
	@Column(name="die_avg")
	private Float die_avg;
	
	@Column(name="faddiness")
	private Integer faddiness;
	
	@Column(name="status")
	private Integer status;

	public Sperm(
			Integer pig_id, 
			Integer sperm_count, 
			Date date, Float volume, 
			Integer doses, 
			Integer used,
			Float activity, 
			Float c, 
			Float life_avg, 
			Float die_avg, 
			Integer faddiness, 
			Integer status) 
	{
				this.pig_id = pig_id;
				this.sperm_count = sperm_count;
				this.date = date;
				this.volume = volume;
				this.doses = doses;
				this.used = used;
				this.activity = activity;
				this.c = c;
				this.life_avg = life_avg;
				this.die_avg = die_avg;
				this.faddiness = faddiness;
				this.status = status;
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

	public Integer getSperm_count() {
		return sperm_count;
	}

	public void setSperm_count(Integer sperm_count) {
		this.sperm_count = sperm_count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public Integer getDoses() {
		return doses;
	}

	public void setDoses(Integer doses) {
		this.doses = doses;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Float getActivity() {
		return activity;
	}

	public void setActivity(Float activity) {
		this.activity = activity;
	}

	public Float getC() {
		return c;
	}

	public void setC(Float c) {
		this.c = c;
	}

	public Float getLife_avg() {
		return life_avg;
	}

	public void setLife_avg(Float life_avg) {
		this.life_avg = life_avg;
	}

	public Float getDie_avg() {
		return die_avg;
	}

	public void setDie_avg(Float die_avg) {
		this.die_avg = die_avg;
	}

	public Integer getFaddiness() {
		return faddiness;
	}

	public void setFaddiness(Integer faddiness) {
		this.faddiness = faddiness;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}

package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="breedings")
public class Breedings extends Auditable implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pig_id")
	private Pigs pig;
	
	@Column(name="date")
	private Date date;
	
//	@Column(name="log_id")
//	private Integer logId;

	@Column(name="type_id")
	private Integer typeId;
	
	@Column(name="description")
	private String description;

	@Column(name="breeding_count")
	private Integer breedingCount;
	
	@Column(name="breeding_next")
	private Date breedingNext;
	
	@Column(name="mating_estimate")
	private Date matingEstimate;
	
	@Column(name="mating_real")
	private Date matingReal;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Breedings() {
	}

	public Breedings(Pigs pig, Date date, Integer typeId, String description, Integer breedingCount, Date breedingNext, Date matingEstimate, Date matingReal, Boolean delFlag) {
		this.pig = pig;
		this.date = date;
		this.typeId = typeId;
		this.description = description;
		this.breedingCount = breedingCount;
		this.breedingNext = breedingNext;
		this.matingEstimate = matingEstimate;
		this.matingReal = matingReal;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pigs getPig() {
		return pig;
	}

	public void setPig(Pigs pig) {
		this.pig = pig;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBreedingCount() {
		return breedingCount;
	}

	public void setBreedingCount(Integer breedingCount) {
		this.breedingCount = breedingCount;
	}

	public Date getBreedingNext() {
		return breedingNext;
	}

	public void setBreedingNext(Date breedingNext) {
		this.breedingNext = breedingNext;
	}

	public Date getMatingEstimate() {
		return matingEstimate;
	}

	public void setMatingEstimate(Date matingEstimate) {
		this.matingEstimate = matingEstimate;
	}

	public Date getMatingReal() {
		return matingReal;
	}

	public void setMatingReal(Date matingReal) {
		this.matingReal = matingReal;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

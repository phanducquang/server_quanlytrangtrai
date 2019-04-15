package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="sperm")
public class Sperm extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pig_id")
	private Pigs pig;
	
	@Column(name="sperm_count")
	private Integer spermCount;
	
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
	private Float lifeAvg;
	
	@Column(name="die_avg")
	private Float dieAvg;
	
	@Column(name="faddiness")
	private Integer faddiness;
	
	@Column(name="status")
	private Integer status;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Sperm() {
	}

	public Sperm(Pigs pig, Integer spermCount, Date date, Float volume, Integer doses, Integer used, Float activity, Float c, Float lifeAvg, Float dieAvg, Integer faddiness, Integer status, Boolean delFlag) {
		this.pig = pig;
		this.spermCount = spermCount;
		this.date = date;
		this.volume = volume;
		this.doses = doses;
		this.used = used;
		this.activity = activity;
		this.c = c;
		this.lifeAvg = lifeAvg;
		this.dieAvg = dieAvg;
		this.faddiness = faddiness;
		this.status = status;
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

	public Integer getSpermCount() {
		return spermCount;
	}

	public void setSpermCount(Integer spermCount) {
		this.spermCount = spermCount;
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

	public Float getLifeAvg() {
		return lifeAvg;
	}

	public void setLifeAvg(Float lifeAvg) {
		this.lifeAvg = lifeAvg;
	}

	public Float getDieAvg() {
		return dieAvg;
	}

	public void setDieAvg(Float dieAvg) {
		this.dieAvg = dieAvg;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

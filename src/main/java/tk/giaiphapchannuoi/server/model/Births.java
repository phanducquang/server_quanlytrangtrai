package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="births")
public class Births implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="mating_id")
	private Integer matingId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer logId;
	
	@Column(name="parities")
	private Integer parities;

	@Column(name="borning")
	private Integer borning;
	
	@Column(name="fetal_weight")
	private Float fetalWeight;
	
	@Column(name="selected")
	private Integer selected;

	@Column(name="die_before_borning")
	private Integer dieBeforeBorning;

	@Column(name="die_borning")
	private Integer dieBorning;
	
	@Column(name="die_black")
	private Integer dieBlack;
	
	@Column(name="defect")
	private Integer defect;
	
	@Column(name="small_remove")
	private Integer smallRemove;
	
	@Column(name="remain")
	private Integer remain;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Births() {
	}

	public Births(Integer matingId, Date date, Integer logId, Integer parities, Integer borning, Float fetalWeight, Integer selected, Integer dieBeforeBorning, Integer dieBorning, Integer dieBlack, Integer defect, Integer smallRemove, Integer remain, Boolean delFlag) {
		this.matingId = matingId;
		this.date = date;
		this.logId = logId;
		this.parities = parities;
		this.borning = borning;
		this.fetalWeight = fetalWeight;
		this.selected = selected;
		this.dieBeforeBorning = dieBeforeBorning;
		this.dieBorning = dieBorning;
		this.dieBlack = dieBlack;
		this.defect = defect;
		this.smallRemove = smallRemove;
		this.remain = remain;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatingId() {
		return matingId;
	}

	public void setMatingId(Integer matingId) {
		this.matingId = matingId;
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

	public Integer getParities() {
		return parities;
	}

	public void setParities(Integer parities) {
		this.parities = parities;
	}

	public Integer getBorning() {
		return borning;
	}

	public void setBorning(Integer borning) {
		this.borning = borning;
	}

	public Float getFetalWeight() {
		return fetalWeight;
	}

	public void setFetalWeight(Float fetalWeight) {
		this.fetalWeight = fetalWeight;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getDieBeforeBorning() {
		return dieBeforeBorning;
	}

	public void setDieBeforeBorning(Integer dieBeforeBorning) {
		this.dieBeforeBorning = dieBeforeBorning;
	}

	public Integer getDieBorning() {
		return dieBorning;
	}

	public void setDieBorning(Integer dieBorning) {
		this.dieBorning = dieBorning;
	}

	public Integer getDieBlack() {
		return dieBlack;
	}

	public void setDieBlack(Integer dieBlack) {
		this.dieBlack = dieBlack;
	}

	public Integer getDefect() {
		return defect;
	}

	public void setDefect(Integer defect) {
		this.defect = defect;
	}

	public Integer getSmallRemove() {
		return smallRemove;
	}

	public void setSmallRemove(Integer smallRemove) {
		this.smallRemove = smallRemove;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

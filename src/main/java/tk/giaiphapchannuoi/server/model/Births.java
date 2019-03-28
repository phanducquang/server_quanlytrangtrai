package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="births")
public class Births {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="mating_id")
	@ManyToOne
	private Integer mating_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer log_id;
	
	@Column(name="parities")
	private Integer parities;
	
	@Column(name="boming")
	private Integer boming;
	
	@Column(name="fetal_weight")
	private Float fetal_weight;
	
	@Column(name="selected")
	private Integer selected;
	
	@Column(name="die_before_boming")
	private Integer die_before_boming;
	
	@Column(name="die_boming")
	private Integer die_boming;
	
	@Column(name="die_black")
	private Integer die_black;
	
	@Column(name="defect")
	private Integer defect;
	
	@Column(name="small_remove")
	private Integer small_remove;
	
	@Column(name="remain")
	private Integer remain;

	public Births(
			Integer mating_id, 
			Date date, 
			Integer log_id, 
			Integer parities, 
			Integer boming, 
			Float fetal_weight,
			Integer selected, 
			Integer die_before_boming, 
			Integer die_boming, 
			Integer die_black, 
			Integer defect,
			Integer small_remove, 
			Integer remain) 
	{
				this.mating_id = mating_id;
				this.date = date;
				this.log_id = log_id;
				this.parities = parities;
				this.boming = boming;
				this.fetal_weight = fetal_weight;
				this.selected = selected;
				this.die_before_boming = die_before_boming;
				this.die_boming = die_boming;
				this.die_black = die_black;
				this.defect = defect;
				this.small_remove = small_remove;
				this.remain = remain;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMating_id() {
		return mating_id;
	}

	public void setMating_id(Integer mating_id) {
		this.mating_id = mating_id;
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

	public Integer getParities() {
		return parities;
	}

	public void setParities(Integer parities) {
		this.parities = parities;
	}

	public Integer getBoming() {
		return boming;
	}

	public void setBoming(Integer boming) {
		this.boming = boming;
	}

	public Float getFetal_weight() {
		return fetal_weight;
	}

	public void setFetal_weight(Float fetal_weight) {
		this.fetal_weight = fetal_weight;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getDie_before_boming() {
		return die_before_boming;
	}

	public void setDie_before_boming(Integer die_before_boming) {
		this.die_before_boming = die_before_boming;
	}

	public Integer getDie_boming() {
		return die_boming;
	}

	public void setDie_boming(Integer die_boming) {
		this.die_boming = die_boming;
	}

	public Integer getDie_black() {
		return die_black;
	}

	public void setDie_black(Integer die_black) {
		this.die_black = die_black;
	}

	public Integer getDefect() {
		return defect;
	}

	public void setDefect(Integer defect) {
		this.defect = defect;
	}

	public Integer getSmall_remove() {
		return small_remove;
	}

	public void setSmall_remove(Integer small_remove) {
		this.small_remove = small_remove;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}
	
	
}

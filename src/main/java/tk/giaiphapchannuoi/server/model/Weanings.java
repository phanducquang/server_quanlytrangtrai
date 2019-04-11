package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="weanings")
public class Weanings implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="pig_id")
	private Integer pigId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer logId;
	
	@Column(name="sum_child_weight")
	private Float sumChildWeight;
	
	@Column(name="quantity")
	private Integer quantity;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Weanings() {
	}

	public Weanings(Integer pigId, Date date, Integer logId, Float sumChildWeight, Integer quantity, Boolean delFlag) {
		this.pigId = pigId;
		this.date = date;
		this.logId = logId;
		this.sumChildWeight = sumChildWeight;
		this.quantity = quantity;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPigId() {
		return pigId;
	}

	public void setPigId(Integer pigId) {
		this.pigId = pigId;
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

	public Float getSumChildWeight() {
		return sumChildWeight;
	}

	public void setSumChildWeight(Float sumChildWeight) {
		this.sumChildWeight = sumChildWeight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

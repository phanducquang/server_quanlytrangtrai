package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Groups implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="group_code")
	private String groupCode;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name="round_id")
	@ManyToOne
	private Integer roundId;
	
	@Column(name="avg_birthday")
	private Date avgBirthday;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="overview_status")
	private String overviewStatus;
	
	@Column(name="origin_sum_weight")
	private Float originSumWeight;
	
	@Column(name="origin_agv_weight")
	private Float originAgvWeight;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="mark")
	private Integer mark;
	
	@Column(name="health_status")
	private Integer healthStatus;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Groups() {
	}

	public Groups(String groupCode, Integer parentId, Integer roundId, Date avgBirthday, Integer quantity, String overviewStatus, Float originSumWeight, Float originAgvWeight, Integer status, Integer mark, Integer healthStatus, String description, Boolean delFlag) {
		this.groupCode = groupCode;
		this.parentId = parentId;
		this.roundId = roundId;
		this.avgBirthday = avgBirthday;
		this.quantity = quantity;
		this.overviewStatus = overviewStatus;
		this.originSumWeight = originSumWeight;
		this.originAgvWeight = originAgvWeight;
		this.status = status;
		this.mark = mark;
		this.healthStatus = healthStatus;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getRoundId() {
		return roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	public Date getAvgBirthday() {
		return avgBirthday;
	}

	public void setAvgBirthday(Date avgBirthday) {
		this.avgBirthday = avgBirthday;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOverviewStatus() {
		return overviewStatus;
	}

	public void setOverviewStatus(String overviewStatus) {
		this.overviewStatus = overviewStatus;
	}

	public Float getOriginSumWeight() {
		return originSumWeight;
	}

	public void setOriginSumWeight(Float originSumWeight) {
		this.originSumWeight = originSumWeight;
	}

	public Float getOriginAgvWeight() {
		return originAgvWeight;
	}

	public void setOriginAgvWeight(Float originAgvWeight) {
		this.originAgvWeight = originAgvWeight;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

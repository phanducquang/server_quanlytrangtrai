package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Groups extends Auditable implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="group_code")
	private String groupCode;
	
	@Column(name="parent_id")
	private Integer parentId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="round_id")
	private Rounds round;
	
	@Column(name="avg_birthday")
	private Date avgBirthday;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="overview_status")
	private String overviewStatus;
	
	@Column(name="origin_sum_weight")
	private Float originSumWeight;
	
	@Column(name="origin_avg_weight")
	private Float originAvgWeight;
	
	@Column(name="status")
	private Integer status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mark")
	private MarkTypes mark;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="health_status")
	private HealthStatus healthStatus;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Groups() {
	}

	public Groups(String groupCode, Integer parentId, Rounds round, Date avgBirthday, Integer quantity, String overviewStatus, Float originSumWeight, Float originAvgWeight, Integer status, MarkTypes mark, HealthStatus healthStatus, String description, Boolean delFlag) {
		this.groupCode = groupCode;
		this.parentId = parentId;
		this.round = round;
		this.avgBirthday = avgBirthday;
		this.quantity = quantity;
		this.overviewStatus = overviewStatus;
		this.originSumWeight = originSumWeight;
		this.originAvgWeight = originAvgWeight;
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

	public Rounds getRound() {
		return round;
	}

	public void setRound(Rounds round) {
		this.round = round;
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

	public Float getOriginAvgWeight() {
		return originAvgWeight;
	}

	public void setOriginAvgWeight(Float originAvgWeight) {
		this.originAvgWeight = originAvgWeight;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MarkTypes getMark() {
		return mark;
	}

	public void setMark(MarkTypes mark) {
		this.mark = mark;
	}

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
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

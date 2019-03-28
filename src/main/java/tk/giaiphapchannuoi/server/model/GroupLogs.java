package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="group_logs")
public class GroupLogs {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="action_type")
	private Integer action_type;
	
	@Column(name="group_id")
	@ManyToOne
	private Integer group_id;
	
	@Column(name="group_code")
	private String group_code;
	
	@Column(name="parent_id")
	private Integer parent_id;
	
	@Column(name="round_id")
	private Integer round_id;
	
	@Column(name="avg_birthday")
	private Date avg_birthday;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="overview_status")
	private String overview_status;
	
	@Column(name="origin_sum_weight")
	private Float origin_sum_weight;
	
	@Column(name="origin_avg_weight")
	private Float origin_avg_weight;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="mark")
	private Integer mark;
	
	@Column(name="health_status")
	private Integer health_status;
	
	@Column(name="description")
	private String description;

	public GroupLogs(
			Date date, 
			Integer action_type, 
			Integer group_id, 
			String group_code, 
			Integer parent_id,
			Integer round_id, 
			Date avg_birthday, 
			Integer quantity, 
			String overview_status, 
			Float origin_sum_weight,
			Float origin_avg_weight, 
			Integer status, 
			Integer mark, 
			Integer health_status, 
			String description) 
	{
		this.date = date;
		this.action_type = action_type;
		this.group_id = group_id;
		this.group_code = group_code;
		this.parent_id = parent_id;
		this.round_id = round_id;
		this.avg_birthday = avg_birthday;
		this.quantity = quantity;
		this.overview_status = overview_status;
		this.origin_sum_weight = origin_sum_weight;
		this.origin_avg_weight = origin_avg_weight;
		this.status = status;
		this.mark = mark;
		this.health_status = health_status;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAction_type() {
		return action_type;
	}

	public void setAction_type(Integer action_type) {
		this.action_type = action_type;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public String getGroup_code() {
		return group_code;
	}

	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getRound_id() {
		return round_id;
	}

	public void setRound_id(Integer round_id) {
		this.round_id = round_id;
	}

	public Date getAvg_birthday() {
		return avg_birthday;
	}

	public void setAvg_birthday(Date avg_birthday) {
		this.avg_birthday = avg_birthday;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOverview_status() {
		return overview_status;
	}

	public void setOverview_status(String overview_status) {
		this.overview_status = overview_status;
	}

	public Float getOrigin_sum_weight() {
		return origin_sum_weight;
	}

	public void setOrigin_sum_weight(Float origin_sum_weight) {
		this.origin_sum_weight = origin_sum_weight;
	}

	public Float getOrigin_avg_weight() {
		return origin_avg_weight;
	}

	public void setOrigin_avg_weight(Float origin_avg_weight) {
		this.origin_avg_weight = origin_avg_weight;
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

	public Integer getHealth_status() {
		return health_status;
	}

	public void setHealth_status(Integer health_status) {
		this.health_status = health_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

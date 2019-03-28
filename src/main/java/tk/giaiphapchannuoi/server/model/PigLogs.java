package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="pig_logs")
public class PigLogs {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="action_type")
	private Integer action_type;
	
	@Column(name="action_id")
	private Integer action_id;
	
	@Column(name="pig_id")
	@ManyToOne
	private Integer pig_id;
	
	@Column(name="pig_code")
	private String pig_code;
	
	@Column(name="house_id")
	private Integer house_id;
	
	@Column(name="round_id")
	private Integer round_id;
	
	@Column(name="breed_id")
	private Integer breed_id;
	
	@Column(name="gender")
	private Integer gender;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="born_weight")
	private Float born_weight;
	
	@Column(name="born_status")
	private Integer born_status;
	
	@Column(name="origin_id")
	private Float origin_id;
	
	@Column(name="origin_weight")
	private Float origin_weight;
	
	@Column(name="origin_father")
	private String origin_father;
	
	@Column(name="origin_mother")
	private String origin_mother;
	
	@Column(name="receive_weight")
	private Float receive_weight;
	
	@Column(name="health_point")
	private Float health_point;
	
	@Column(name="foot")
	private Integer foot;
	
	@Column(name="function_udder")
	private Integer function_udder;
	
	@Column(name="total_udder")
	private Integer total_udder;
	
	@Column(name="gential")
	@ManyToOne
	private Integer gential;
	
	@Column(name="description")
	private String description;
	
	@Column(name="fcr")
	private Float fcr;
	
	@Column(name="adg")
	private Float adg;
	
	@Column(name="bf")
	private Float bf;
	
	@Column(name="filet")
	private Float filet;
	
	@Column(name="long_back")
	private Float long_back;
	
	@Column(name="long_body")
	private Float long_body;
	
	@Column(name="index")
	private Float index;
	
	@Column(name="parities")
	private Integer parities;
	
	@Column(name="images")
	private String images;
	
	@Column(name="health_status")
	private Integer health_status;
	
	@Column(name="breeding_type")
	private Integer breeding_type;
	
	@Column(name="breed_status")
	private Integer breed_status;
	
	@Column(name="pregnancy_status")
	private Integer pregnancy_status;
	
	@Column(name="overview_status")
	private Integer overview_status;
	
	@Column(name="point_review")
	private Integer point_review;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="price_code")
	private Integer price_ocde;

	public PigLogs(
			Date date, 
			Integer action_type, 
			Integer action_id, 
			Integer pig_id, 
			String pig_code, 
			Integer house_id,
			Integer round_id, 
			Integer breed_id, 
			Integer gender, 
			Date birthday, 
			Float born_weight, 
			Integer born_status,
			Float origin_id, 
			Float origin_weight, 
			String origin_father, 
			String origin_mother, 
			Float receive_weight,
			Float health_point, 
			Integer foot, 
			Integer function_udder, 
			Integer total_udder, 
			Integer gential,
			String description, 
			Float fcr, 
			Float adg, 
			Float bf, 
			Float filet, 
			Float long_back, 
			Float long_body,
			Float index, 
			Integer parities, 
			String images, 
			Integer health_status, 
			Integer breeding_type,
			Integer breed_status, 
			Integer pregnancy_status, 
			Integer overview_status, 
			Integer point_review,
			Integer status, 
			Integer price_ocde) {
				this.date = date;
				this.action_type = action_type;
				this.action_id = action_id;
				this.pig_id = pig_id;
				this.pig_code = pig_code;
				this.house_id = house_id;
				this.round_id = round_id;
				this.breed_id = breed_id;
				this.gender = gender;
				this.birthday = birthday;
				this.born_weight = born_weight;
				this.born_status = born_status;
				this.origin_id = origin_id;
				this.origin_weight = origin_weight;
				this.origin_father = origin_father;
				this.origin_mother = origin_mother;
				this.receive_weight = receive_weight;
				this.health_point = health_point;
				this.foot = foot;
				this.function_udder = function_udder;
				this.total_udder = total_udder;
				this.gential = gential;
				this.description = description;
				this.fcr = fcr;
				this.adg = adg;
				this.bf = bf;
				this.filet = filet;
				this.long_back = long_back;
				this.long_body = long_body;
				this.index = index;
				this.parities = parities;
				this.images = images;
				this.health_status = health_status;
				this.breeding_type = breeding_type;
				this.breed_status = breed_status;
				this.pregnancy_status = pregnancy_status;
				this.overview_status = overview_status;
				this.point_review = point_review;
				this.status = status;
				this.price_ocde = price_ocde;
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

	public Integer getAction_id() {
		return action_id;
	}

	public void setAction_id(Integer action_id) {
		this.action_id = action_id;
	}

	public Integer getPig_id() {
		return pig_id;
	}

	public void setPig_id(Integer pig_id) {
		this.pig_id = pig_id;
	}

	public String getPig_code() {
		return pig_code;
	}

	public void setPig_code(String pig_code) {
		this.pig_code = pig_code;
	}

	public Integer getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}

	public Integer getRound_id() {
		return round_id;
	}

	public void setRound_id(Integer round_id) {
		this.round_id = round_id;
	}

	public Integer getBreed_id() {
		return breed_id;
	}

	public void setBreed_id(Integer breed_id) {
		this.breed_id = breed_id;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Float getBorn_weight() {
		return born_weight;
	}

	public void setBorn_weight(Float born_weight) {
		this.born_weight = born_weight;
	}

	public Integer getBorn_status() {
		return born_status;
	}

	public void setBorn_status(Integer born_status) {
		this.born_status = born_status;
	}

	public Float getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(Float origin_id) {
		this.origin_id = origin_id;
	}

	public Float getOrigin_weight() {
		return origin_weight;
	}

	public void setOrigin_weight(Float origin_weight) {
		this.origin_weight = origin_weight;
	}

	public String getOrigin_father() {
		return origin_father;
	}

	public void setOrigin_father(String origin_father) {
		this.origin_father = origin_father;
	}

	public String getOrigin_mother() {
		return origin_mother;
	}

	public void setOrigin_mother(String origin_mother) {
		this.origin_mother = origin_mother;
	}

	public Float getReceive_weight() {
		return receive_weight;
	}

	public void setReceive_weight(Float receive_weight) {
		this.receive_weight = receive_weight;
	}

	public Float getHealth_point() {
		return health_point;
	}

	public void setHealth_point(Float health_point) {
		this.health_point = health_point;
	}

	public Integer getFoot() {
		return foot;
	}

	public void setFoot(Integer foot) {
		this.foot = foot;
	}

	public Integer getFunction_udder() {
		return function_udder;
	}

	public void setFunction_udder(Integer function_udder) {
		this.function_udder = function_udder;
	}

	public Integer getTotal_udder() {
		return total_udder;
	}

	public void setTotal_udder(Integer total_udder) {
		this.total_udder = total_udder;
	}

	public Integer getGential() {
		return gential;
	}

	public void setGential(Integer gential) {
		this.gential = gential;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getFcr() {
		return fcr;
	}

	public void setFcr(Float fcr) {
		this.fcr = fcr;
	}

	public Float getAdg() {
		return adg;
	}

	public void setAdg(Float adg) {
		this.adg = adg;
	}

	public Float getBf() {
		return bf;
	}

	public void setBf(Float bf) {
		this.bf = bf;
	}

	public Float getFilet() {
		return filet;
	}

	public void setFilet(Float filet) {
		this.filet = filet;
	}

	public Float getLong_back() {
		return long_back;
	}

	public void setLong_back(Float long_back) {
		this.long_back = long_back;
	}

	public Float getLong_body() {
		return long_body;
	}

	public void setLong_body(Float long_body) {
		this.long_body = long_body;
	}

	public Float getIndex() {
		return index;
	}

	public void setIndex(Float index) {
		this.index = index;
	}

	public Integer getParities() {
		return parities;
	}

	public void setParities(Integer parities) {
		this.parities = parities;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getHealth_status() {
		return health_status;
	}

	public void setHealth_status(Integer health_status) {
		this.health_status = health_status;
	}

	public Integer getBreeding_type() {
		return breeding_type;
	}

	public void setBreeding_type(Integer breeding_type) {
		this.breeding_type = breeding_type;
	}

	public Integer getBreed_status() {
		return breed_status;
	}

	public void setBreed_status(Integer breed_status) {
		this.breed_status = breed_status;
	}

	public Integer getPregnancy_status() {
		return pregnancy_status;
	}

	public void setPregnancy_status(Integer pregnancy_status) {
		this.pregnancy_status = pregnancy_status;
	}

	public Integer getOverview_status() {
		return overview_status;
	}

	public void setOverview_status(Integer overview_status) {
		this.overview_status = overview_status;
	}

	public Integer getPoint_review() {
		return point_review;
	}

	public void setPoint_review(Integer point_review) {
		this.point_review = point_review;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPrice_ocde() {
		return price_ocde;
	}

	public void setPrice_ocde(Integer price_ocde) {
		this.price_ocde = price_ocde;
	}
	
	
}

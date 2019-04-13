package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="pig_logs")
public class PigLogs extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="action_type")
	private Integer actionType;
	
	@Column(name="action_id")
	private Integer actionId;
	
	@Column(name="pig_id")
	private Integer pigId;
	
	@Column(name="pig_code")
	private String pigCode;
	
	@Column(name="house_id")
	private Integer houseId;
	
	@Column(name="round_id")
	private Integer roundId;
	
	@Column(name="breed_id")
	private Integer breedId;
	
	@Column(name="gender")
	private Integer gender;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="born_weight")
	private Float bornWeight;
	
	@Column(name="born_status")
	private Integer bornStatus;
	
	@Column(name="origin_id")
	private Float originId;
	
	@Column(name="origin_weight")
	private Float originWeight;
	
	@Column(name="origin_father")
	private String originFather;
	
	@Column(name="origin_mother")
	private String originMother;
	
	@Column(name="receive_weight")
	private Float receiveWeight;
	
	@Column(name="health_point")
	private Float healthPoint;
	
	@Column(name="foot")
	private Integer foot;
	
	@Column(name="function_udder")
	private Integer functionUdder;
	
	@Column(name="total_udder")
	private Integer totalUdder;
	
	@Column(name="gential")
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
	private Float longBack;
	
	@Column(name="long_body")
	private Float longBody;
	
	@Column(name="index")
	private Float index;
	
	@Column(name="parities")
	private Integer parities;
	
	@Column(name="images")
	private String images;
	
	@Column(name="health_status")
	private Integer healthStatus;
	
	@Column(name="breeding_type")
	private Integer breedingType;
	
	@Column(name="breed_status")
	private Integer breedStatus;
	
	@Column(name="pregnancy_status")
	private Integer pregnancyStatus;
	
	@Column(name="overview_status")
	private Integer overviewStatus;
	
	@Column(name="point_review")
	private Integer pointReview;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="price_code")
	private Integer priceCode;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public PigLogs() {
	}

	public PigLogs(Date date, Integer actionType, Integer actionId, Integer pigId, String pigCode, Integer houseId, Integer roundId, Integer breedId, Integer gender, Date birthday, Float bornWeight, Integer bornStatus, Float originId, Float originWeight, String originFather, String originMother, Float receiveWeight, Float healthPoint, Integer foot, Integer functionUdder, Integer totalUdder, Integer gential, String description, Float fcr, Float adg, Float bf, Float filet, Float longBack, Float longBody, Float index, Integer parities, String images, Integer healthStatus, Integer breedingType, Integer breedStatus, Integer pregnancyStatus, Integer overviewStatus, Integer pointReview, Integer status, Integer priceCode, Boolean delFlag) {
		this.date = date;
		this.actionType = actionType;
		this.actionId = actionId;
		this.pigId = pigId;
		this.pigCode = pigCode;
		this.houseId = houseId;
		this.roundId = roundId;
		this.breedId = breedId;
		this.gender = gender;
		this.birthday = birthday;
		this.bornWeight = bornWeight;
		this.bornStatus = bornStatus;
		this.originId = originId;
		this.originWeight = originWeight;
		this.originFather = originFather;
		this.originMother = originMother;
		this.receiveWeight = receiveWeight;
		this.healthPoint = healthPoint;
		this.foot = foot;
		this.functionUdder = functionUdder;
		this.totalUdder = totalUdder;
		this.gential = gential;
		this.description = description;
		this.fcr = fcr;
		this.adg = adg;
		this.bf = bf;
		this.filet = filet;
		this.longBack = longBack;
		this.longBody = longBody;
		this.index = index;
		this.parities = parities;
		this.images = images;
		this.healthStatus = healthStatus;
		this.breedingType = breedingType;
		this.breedStatus = breedStatus;
		this.pregnancyStatus = pregnancyStatus;
		this.overviewStatus = overviewStatus;
		this.pointReview = pointReview;
		this.status = status;
		this.priceCode = priceCode;
		this.delFlag = delFlag;
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

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public Integer getPigId() {
		return pigId;
	}

	public void setPigId(Integer pigId) {
		this.pigId = pigId;
	}

	public String getPigCode() {
		return pigCode;
	}

	public void setPigCode(String pigCode) {
		this.pigCode = pigCode;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getRoundId() {
		return roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	public Integer getBreedId() {
		return breedId;
	}

	public void setBreedId(Integer breedId) {
		this.breedId = breedId;
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

	public Float getBornWeight() {
		return bornWeight;
	}

	public void setBornWeight(Float bornWeight) {
		this.bornWeight = bornWeight;
	}

	public Integer getBornStatus() {
		return bornStatus;
	}

	public void setBornStatus(Integer bornStatus) {
		this.bornStatus = bornStatus;
	}

	public Float getOriginId() {
		return originId;
	}

	public void setOriginId(Float originId) {
		this.originId = originId;
	}

	public Float getOriginWeight() {
		return originWeight;
	}

	public void setOriginWeight(Float originWeight) {
		this.originWeight = originWeight;
	}

	public String getOriginFather() {
		return originFather;
	}

	public void setOriginFather(String originFather) {
		this.originFather = originFather;
	}

	public String getOriginMother() {
		return originMother;
	}

	public void setOriginMother(String originMother) {
		this.originMother = originMother;
	}

	public Float getReceiveWeight() {
		return receiveWeight;
	}

	public void setReceiveWeight(Float receiveWeight) {
		this.receiveWeight = receiveWeight;
	}

	public Float getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(Float healthPoint) {
		this.healthPoint = healthPoint;
	}

	public Integer getFoot() {
		return foot;
	}

	public void setFoot(Integer foot) {
		this.foot = foot;
	}

	public Integer getFunctionUdder() {
		return functionUdder;
	}

	public void setFunctionUdder(Integer functionUdder) {
		this.functionUdder = functionUdder;
	}

	public Integer getTotalUdder() {
		return totalUdder;
	}

	public void setTotalUdder(Integer totalUdder) {
		this.totalUdder = totalUdder;
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

	public Float getLongBack() {
		return longBack;
	}

	public void setLongBack(Float longBack) {
		this.longBack = longBack;
	}

	public Float getLongBody() {
		return longBody;
	}

	public void setLongBody(Float longBody) {
		this.longBody = longBody;
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

	public Integer getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}

	public Integer getBreedingType() {
		return breedingType;
	}

	public void setBreedingType(Integer breedingType) {
		this.breedingType = breedingType;
	}

	public Integer getBreedStatus() {
		return breedStatus;
	}

	public void setBreedStatus(Integer breedStatus) {
		this.breedStatus = breedStatus;
	}

	public Integer getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(Integer pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public Integer getOverviewStatus() {
		return overviewStatus;
	}

	public void setOverviewStatus(Integer overviewStatus) {
		this.overviewStatus = overviewStatus;
	}

	public Integer getPointReview() {
		return pointReview;
	}

	public void setPointReview(Integer pointReview) {
		this.pointReview = pointReview;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(Integer priceCode) {
		this.priceCode = priceCode;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

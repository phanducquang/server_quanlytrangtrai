package tk.giaiphapchannuoi.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Pigs")
public class Pigs extends Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="pig_code")
	private String pigCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="house_id")
	private Houses house;

	@ManyToOne(fetch = FetchType.EAGER)//bỏ
	@JoinColumn(name="round_id")
	private Rounds round;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="breed_id")
	private Breeds breed;

	@Column(name="birth_id")
	private Integer birthId;

	@Column(name="gender")
	private Integer gender;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="born_weight")
	private Float born_weight;
	
	@Column(name="born_status")
	private Float bornStatus;
	
	@Column(name="origin_id")
	private Integer originId;
	
	@Column(name="origin_father")
	private String originFather;
	
	@Column(name="origin_mother")
	private String originMother;
	
	@Column(name="origin_weight")
	private Float originWeight;
	
	@Column(name="receive_weight")
	private Float receiveWeight;
	
	@Column(name="health_point")
	private Float healthPoint;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="foot")
	private FootType foot;
	
	@Column(name="function_udder")
	private Integer functionUdder;
	
	@Column(name="total_udder")
	private Integer totalUdder;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="gential")
	private GentialType gentialType;
	
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="health_status")
	private HealthStatus healthStatus;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="breeding_type")
//	private BreedingType breedingType;

	@Column(name="breeding_type")
	private Integer breedingType;
	
	@Column(name="breed_status")
	private Integer breedStatus;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pregnancy_status")
	private PregnancyStatus pregnancyStatus;

	@Column(name="point_review")
	private Integer point_review;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="status")
	private Status status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="price_code")
	private PriceCodes priceCode;

	@Column(name="overview_status")
	private Integer overviewStatus;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Pigs() {
	}

	public Pigs(String pigCode, Houses house, Rounds round, Breeds breed, Integer birthId, Integer gender, Date birthday, Float born_weight, Float bornStatus, Integer originId, String originFather, String originMother, Float originWeight, Float receiveWeight, Float healthPoint, FootType foot, Integer functionUdder, Integer totalUdder, GentialType gentialType, String description, Float fcr, Float adg, Float bf, Float filet, Float longBack, Float longBody, Float index, Integer parities, String images, HealthStatus healthStatus, Integer breedingType, Integer breedStatus, PregnancyStatus pregnancyStatus, Integer point_review, Status status, PriceCodes priceCode, Integer overviewStatus, Boolean delFlag) {
		this.pigCode = pigCode;
		this.house = house;
		this.round = round;
		this.breed = breed;
		this.birthId = birthId;
		this.gender = gender;
		this.birthday = birthday;
		this.born_weight = born_weight;
		this.bornStatus = bornStatus;
		this.originId = originId;
		this.originFather = originFather;
		this.originMother = originMother;
		this.originWeight = originWeight;
		this.receiveWeight = receiveWeight;
		this.healthPoint = healthPoint;
		this.foot = foot;
		this.functionUdder = functionUdder;
		this.totalUdder = totalUdder;
		this.gentialType = gentialType;
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
		this.point_review = point_review;
		this.status = status;
		this.priceCode = priceCode;
		this.overviewStatus = overviewStatus;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPigCode() {
		return pigCode;
	}

	public void setPigCode(String pigCode) {
		this.pigCode = pigCode;
	}

	public Houses getHouse() {
		return house;
	}

	public void setHouse(Houses house) {
		this.house = house;
	}

	public Rounds getRound() {
		return round;
	}

	public Integer getBirthId() {
		return birthId;
	}

	public void setBirthId(Integer birthId) {
		this.birthId = birthId;
	}

	public void setRound(Rounds round) {
		this.round = round;
	}

	public Breeds getBreed() {
		return breed;
	}

	public void setBreed(Breeds breed) {
		this.breed = breed;
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

	public Float getBornStatus() {
		return bornStatus;
	}

	public void setBornStatus(Float bornStatus) {
		this.bornStatus = bornStatus;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originId) {
		this.originId = originId;
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

	public Float getOriginWeight() {
		return originWeight;
	}

	public void setOriginWeight(Float originWeight) {
		this.originWeight = originWeight;
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

	public FootType getFoot() {
		return foot;
	}

	public void setFoot(FootType foot) {
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

	public GentialType getGentialType() {
		return gentialType;
	}

	public void setGentialType(GentialType gentialType) {
		this.gentialType = gentialType;
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

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

//	public BreedingType getBreedingType() {
//		return breedingType;
//	}
//
//	public void setBreedingType(BreedingType breedingType) {
//		this.breedingType = breedingType;
//	}


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

	public PregnancyStatus getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(PregnancyStatus pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public Integer getPoint_review() {
		return point_review;
	}

	public void setPoint_review(Integer point_review) {
		this.point_review = point_review;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public PriceCodes getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCodes priceCode) {
		this.priceCode = priceCode;
	}

	public Integer getOverviewStatus() {
		return overviewStatus;
	}

	public void setOverviewStatus(Integer overviewStatus) {
		this.overviewStatus = overviewStatus;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

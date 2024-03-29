package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Pigs")
public class PigsDTO implements Serializable {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name="pig_code")
	private String pigCode;

	@Column(name="cage_id")
	private Integer houseId;

	@Column(name="pig_type")
	private String pigType;

	@Column(name = "birth_id")
	private Integer birthId;

	@Column(name="breed_id")
	private Integer breedId;
	
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

	@Column(name="foot")
	private Integer footTypeId;
	
	@Column(name="function_udder")
	private Integer functionUdder;
	
	@Column(name="total_udder")
	private Integer totalUdder;
	
	@Column(name="gential")
	private Integer gentialTypeId;
	
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
	private Integer healthStatusId;

	@Column(name="breeding_type")
	private Integer breedingType;
	
	@Column(name="breed_status")
	private Integer breedStatus;

	@Column(name="pregnancy_status")
	private Integer pregnancyStatusId;

	@Column(name="point_review")
	private Integer point_review;
	
	@Column(name="status")
	private Integer statusId;

	@Column(name="overview_status")
	private Integer overviewStatus;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public PigsDTO() {
	}

	public PigsDTO(Integer id, String pigCode, Integer houseId, String pigType, Integer birthId, Integer breedId, Integer gender, Date birthday, Float born_weight, Float bornStatus, Integer originId, String originFather, String originMother, Float originWeight, Float receiveWeight, Float healthPoint, Integer footTypeId, Integer functionUdder, Integer totalUdder, Integer gentialTypeId, String description, Float fcr, Float adg, Float bf, Float filet, Float longBack, Float longBody, Float index, Integer parities, String images, Integer healthStatusId, Integer breedingType, Integer breedStatus, Integer pregnancyStatusId, Integer point_review, Integer statusId, Integer overviewStatus, Boolean delFlag) {
		this.id = id;
		this.pigCode = pigCode;
		this.houseId = houseId;
		this.pigType = pigType;
		this.birthId = birthId;
		this.breedId = breedId;
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
		this.footTypeId = footTypeId;
		this.functionUdder = functionUdder;
		this.totalUdder = totalUdder;
		this.gentialTypeId = gentialTypeId;
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
		this.healthStatusId = healthStatusId;
		this.breedingType = breedingType;
		this.breedStatus = breedStatus;
		this.pregnancyStatusId = pregnancyStatusId;
		this.point_review = point_review;
		this.statusId = statusId;
		this.overviewStatus = overviewStatus;
		this.delFlag = delFlag;
	}

	public void convertTo(Pigs pig){
		this.id = pig.getId();
		this.pigCode = pig.getPigCode();
		this.houseId = pig.getHouse().getId();
		this.pigType = pig.getPigType();
		this.birthId = pig.getBirthId();
		this.breedId = pig.getBreed().getId();
		this.gender = pig.getGender();
		this.birthday = pig.getBirthday();
		this.born_weight = pig.getBorn_weight();
		this.bornStatus = pig.getBornStatus();
		this.originId = pig.getOriginId();
		this.originFather = pig.getOriginFather();
		this.originMother = pig.getOriginMother();
		this.originWeight = pig.getOriginWeight();
		this.receiveWeight = pig.getReceiveWeight();
		this.healthPoint = pig.getHealthPoint();
		this.footTypeId = pig.getFoot().getId();
		this.functionUdder = pig.getFunctionUdder();
		this.totalUdder = pig.getTotalUdder();
		this.gentialTypeId = pig.getGentialType().getId();
		this.description = pig.getDescription();
		this.fcr = pig.getFcr();
		this.adg = pig.getAdg();
		this.bf = pig.getBf();
		this.filet = pig.getFilet();
		this.longBack = pig.getLongBack();
		this.longBody = pig.getLongBody();
		this.index = pig.getIndex();
		this.parities = pig.getParities();
		this.images = pig.getImages();
		this.healthStatusId = pig.getHealthStatus().getId();
		this.breedingType = pig.getBreedingType();
		this.breedStatus = pig.getBreedStatus();
		this.pregnancyStatusId = pig.getPregnancyStatus().getId();
		this.point_review = pig.getPoint_review();
		this.statusId = pig.getStatus().getId();
		this.overviewStatus = pig.getOverviewStatus();
		this.delFlag = pig.getDelFlag();
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

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getPigType() {
		return pigType;
	}

	public void setPigType(String pigType) {
		this.pigType = pigType;
	}

	public Integer getBirthId() {
		return birthId;
	}

	public void setBirthId(Integer birthId) {
		this.birthId = birthId;
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

	public Integer getFootTypeId() {
		return footTypeId;
	}

	public void setFootTypeId(Integer footTypeId) {
		this.footTypeId = footTypeId;
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

	public Integer getGentialTypeId() {
		return gentialTypeId;
	}

	public void setGentialTypeId(Integer gentialTypeId) {
		this.gentialTypeId = gentialTypeId;
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

	public Integer getHealthStatusId() {
		return healthStatusId;
	}

	public void setHealthStatusId(Integer healthStatusId) {
		this.healthStatusId = healthStatusId;
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

	public Integer getPregnancyStatusId() {
		return pregnancyStatusId;
	}

	public void setPregnancyStatusId(Integer pregnancyStatusId) {
		this.pregnancyStatusId = pregnancyStatusId;
	}

	public Integer getPoint_review() {
		return point_review;
	}

	public void setPoint_review(Integer point_review) {
		this.point_review = point_review;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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

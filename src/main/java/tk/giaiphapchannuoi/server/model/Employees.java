package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="regency_id")
	private Regencies regency;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="farm_id")
	private Farms farm;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private Integer gender;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="cmnd")
	private String cmnd;
	
	@Column(name="date_join")
	private Date dateJoin;
	
	@Column(name="date_off")
	private Date dateOff;
	
	@Column(name="images")
	private String images;
	
	@Column(name="status")
	private Integer status;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Employees() {
	}

	public Employees(Regencies regency, Farms farm, String name, Integer gender, Date birthday, String address, String email, String cmnd, Date dateJoin, Date dateOff, String images, Integer status, Boolean delFlag) {
		this.regency = regency;
		this.farm = farm;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.cmnd = cmnd;
		this.dateJoin = dateJoin;
		this.dateOff = dateOff;
		this.images = images;
		this.status = status;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Regencies getRegency() {
		return regency;
	}

	public void setRegency(Regencies regency) {
		this.regency = regency;
	}

	public Farms getFarm() {
		return farm;
	}

	public void setFarm(Farms farm) {
		this.farm = farm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public Date getDateOff() {
		return dateOff;
	}

	public void setDateOff(Date dateOff) {
		this.dateOff = dateOff;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

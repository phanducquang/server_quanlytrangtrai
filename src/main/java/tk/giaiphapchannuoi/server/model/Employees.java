package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="regency_id")
	@ManyToOne
	private Integer regency_id;
	
	@Column(name="farm_id")
	@ManyToOne
	private Integer farm_id;
	
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
	private Date date_join;
	
	@Column(name="date_off")
	private Date date_off;
	
	@Column(name="images")
	private String images;
	
	@Column(name="status")
	private Integer status;

	public Employees(
			Integer regency_id, 
			Integer farm_id, 
			String name, 
			Integer gender, 
			Date birthday, 
			String address,
			String email, 
			String cmnd, 
			Date date_join, 
			Date date_off, 
			String images, 
			Integer status) 
	{
		this.regency_id = regency_id;
		this.farm_id = farm_id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.cmnd = cmnd;
		this.date_join = date_join;
		this.date_off = date_off;
		this.images = images;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegency_id() {
		return regency_id;
	}

	public void setRegency_id(Integer regency_id) {
		this.regency_id = regency_id;
	}

	public Integer getFarm_id() {
		return farm_id;
	}

	public void setFarm_id(Integer farm_id) {
		this.farm_id = farm_id;
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

	public Date getDate_join() {
		return date_join;
	}

	public void setDate_join(Date date_join) {
		this.date_join = date_join;
	}

	public Date getDate_off() {
		return date_off;
	}

	public void setDate_off(Date date_off) {
		this.date_off = date_off;
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
}

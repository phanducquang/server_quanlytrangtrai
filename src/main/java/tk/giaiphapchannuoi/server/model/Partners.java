package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="partners")
public class Partners {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="manager")
	private String manager;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="agency_name")
	private String agency_name;
	
	@Column(name="agency_address")
	private String agency_address;
	
	@Column(name="agency_phone")
	private String agency_phone;
	
	@Column(name="distribution_name")
	private String distribution_name;
	
	@Column(name="distribution_address")
	private String distribution_address;
	
	@Column(name="distribution_phone")
	private String distribution_phone;
	
	@Column(name="description")
	private String description;

	public Partners(
			String code, 
			String name, 
			String manager, 
			String address, 
			String phone, 
			String agency_name,
			String agency_address, 
			String agency_phone, 
			String distribution_name, 
			String distribution_address,
			String distribution_phone, 
			String description) 
	{
		this.code = code;
		this.name = name;
		this.manager = manager;
		this.address = address;
		this.phone = phone;
		this.agency_name = agency_name;
		this.agency_address = agency_address;
		this.agency_phone = agency_phone;
		this.distribution_name = distribution_name;
		this.distribution_address = distribution_address;
		this.distribution_phone = distribution_phone;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public String getAgency_address() {
		return agency_address;
	}

	public void setAgency_address(String agency_address) {
		this.agency_address = agency_address;
	}

	public String getAgency_phone() {
		return agency_phone;
	}

	public void setAgency_phone(String agency_phone) {
		this.agency_phone = agency_phone;
	}

	public String getDistribution_name() {
		return distribution_name;
	}

	public void setDistribution_name(String distribution_name) {
		this.distribution_name = distribution_name;
	}

	public String getDistribution_address() {
		return distribution_address;
	}

	public void setDistribution_address(String distribution_address) {
		this.distribution_address = distribution_address;
	}

	public String getDistribution_phone() {
		return distribution_phone;
	}

	public void setDistribution_phone(String distribution_phone) {
		this.distribution_phone = distribution_phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

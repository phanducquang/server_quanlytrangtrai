package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="partners")
public class Partners extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
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
	private String agencyName;
	
	@Column(name="agency_address")
	private String agencyAddress;
	
	@Column(name="agency_phone")
	private String agencyPhone;
	
	@Column(name="distribution_name")
	private String distributionName;
	
	@Column(name="distribution_address")
	private String distributionAddress;
	
	@Column(name="distribution_phone")
	private String distributionPhone;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Partners() {
	}

	public Partners(String code, String name, String manager, String address, String phone, String agencyName, String agencyAddress, String agencyPhone, String distributionName, String distributionAddress, String distributionPhone, String description, Boolean delFlag) {
		this.code = code;
		this.name = name;
		this.manager = manager;
		this.address = address;
		this.phone = phone;
		this.agencyName = agencyName;
		this.agencyAddress = agencyAddress;
		this.agencyPhone = agencyPhone;
		this.distributionName = distributionName;
		this.distributionAddress = distributionAddress;
		this.distributionPhone = distributionPhone;
		this.description = description;
		this.delFlag = delFlag;
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

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyAddress() {
		return agencyAddress;
	}

	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}

	public String getAgencyPhone() {
		return agencyPhone;
	}

	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
	}

	public String getDistributionName() {
		return distributionName;
	}

	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}

	public String getDistributionAddress() {
		return distributionAddress;
	}

	public void setDistributionAddress(String distributionAddress) {
		this.distributionAddress = distributionAddress;
	}

	public String getDistributionPhone() {
		return distributionPhone;
	}

	public void setDistributionPhone(String distributionPhone) {
		this.distributionPhone = distributionPhone;
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

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="customers")
public class Customers extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id")
	private CustomerTypes type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="group_id")
	private CustomerGroups group;

	@Column(name="farm_id")
	private String farmId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="company_address")
	private String companyAddress;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="bank")
	private Integer bank;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Customers() {
	}

	public Customers(CustomerTypes type, CustomerGroups group, String farmId, String name, String phone, String email, String address, String companyAddress, String fax, Integer bank, String description, Boolean delFlag) {
		this.type = type;
		this.group = group;
		this.farmId = farmId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.companyAddress = companyAddress;
		this.fax = fax;
		this.bank = bank;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerTypes getType() {
		return type;
	}

	public void setType(CustomerTypes type) {
		this.type = type;
	}

	public CustomerGroups getGroup() {
		return group;
	}

	public void setGroup(CustomerGroups group) {
		this.group = group;
	}

	public String getFarmId() {
		return farmId;
	}

	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getBank() {
		return bank;
	}

	public void setBank(Integer bank) {
		this.bank = bank;
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

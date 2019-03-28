package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="group_id")
	@ManyToOne
	private Integer group_id;
	
	@Column(name="farm_id")
	private Integer farm_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="company_address")
	private String company_address;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="bank")
	private Integer bank;
	
	@Column(name="description")
	private String description;

	public Customers(
			Integer type_id, 
			Integer group_id, 
			Integer farm_id, 
			String name, 
			String phone, 
			String email,
			String address, 
			String company_address, 
			String fax, 
			Integer bank, 
			String description) 
	{
		this.type_id = type_id;
		this.group_id = group_id;
		this.farm_id = farm_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.company_address = company_address;
		this.fax = fax;
		this.bank = bank;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
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

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
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
}

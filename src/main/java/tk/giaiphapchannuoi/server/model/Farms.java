package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="farms")
public class Farms extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id")
	private FarmTypes type;
	
	@Column(name="address")
	private String address;
	
	@Column(name="area")
	private Float area;
	
	@Column(name="total_pig")
	private Integer totalPig;
	
	@Column(name="founding")
	private Date founding;
	
	@Column(name="manager")
	private Integer manager;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Farms() {
	}

	public Farms(FarmTypes type, String address, Float area, Integer totalPig, Date founding, Integer manager, String description, Boolean delFlag) {
		this.type = type;
		this.address = address;
		this.area = area;
		this.totalPig = totalPig;
		this.founding = founding;
		this.manager = manager;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FarmTypes getType() {
		return type;
	}

	public void setType(FarmTypes type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Integer getTotalPig() {
		return totalPig;
	}

	public void setTotalPig(Integer totalPig) {
		this.totalPig = totalPig;
	}

	public Date getFounding() {
		return founding;
	}

	public void setFounding(Date founding) {
		this.founding = founding;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
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

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="permissions")
public class Permisssions extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="group_id")
	private Integer groupId;
	
	@Column(name="show")
	private Integer show;
	
	@Column(name="object_type")
	private Integer objectType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="code")
	private String code;
	
	@Column(name="num_order")
	private Integer order;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Permisssions() {
	}

	public Permisssions(String name, Integer groupId, Integer show, Integer objectType, String description, String code, Integer order, Boolean delFlag) {
		this.name = name;
		this.groupId = groupId;
		this.show = show;
		this.objectType = objectType;
		this.description = description;
		this.code = code;
		this.order = order;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public Integer getObjectType() {
		return objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

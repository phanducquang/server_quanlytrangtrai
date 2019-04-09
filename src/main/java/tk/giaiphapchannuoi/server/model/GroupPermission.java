package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_permissions")
public class GroupPermission implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "group_id")
	private Integer groupId;

	@Column(name = "name")
	private String name;

	@Column(name = "order")
	private Integer order;

	@Column(name = "show")
	private Integer show;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public GroupPermission() {
	}

	public GroupPermission(Integer groupId, String name, Integer order, Integer show, Boolean delFlag) {
		this.groupId = groupId;
		this.name = name;
		this.order = order;
		this.show = show;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

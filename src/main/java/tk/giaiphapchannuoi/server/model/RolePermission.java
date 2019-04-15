package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role_permission")
public class RolePermission extends Auditable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Roles role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id")
	private GroupPermission groupId;

	@Column(name = "params")
	private Integer params;

	@Column(name = "show")
	private Integer show;

	@Column(name = "num_order")
	private Integer order;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public RolePermission() {
	}

	public RolePermission(Roles role, GroupPermission groupId, Integer params, Integer show, Integer order, Boolean delFlag) {
		this.role = role;
		this.groupId = groupId;
		this.params = params;
		this.show = show;
		this.order = order;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public GroupPermission getGroupId() {
		return groupId;
	}

	public void setGroupId(GroupPermission groupId) {
		this.groupId = groupId;
	}

	public Integer getParams() {
		return params;
	}

	public void setParams(Integer params) {
		this.params = params;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
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

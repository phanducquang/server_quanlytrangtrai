package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private Integer id;

	@Column(name = "role_id")
	@ManyToOne
	private Integer role_id;

	@Column(name = "group_id")
	@ManyToOne
	private Integer group_id;

	@Column(name = "params")
	private Integer params;

	@Column(name = "show")
	private Integer show;

	@Column(name = "order")
	private Integer order;

	public RolePermission(Integer role_id, Integer group_id, Integer params, Integer show, Integer order) {
		this.role_id = role_id;
		this.group_id = group_id;
		this.params = params;
		this.show = show;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
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
}

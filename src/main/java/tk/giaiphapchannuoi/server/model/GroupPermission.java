package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name = "group_permissions")
public class GroupPermission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	@OneToMany
	private Integer id;

	@Column(name = "group_id")
	private Integer group_id;

	@Column(name = "name")
	private String name;

	@Column(name = "order")
	private Integer order;

	@Column(name = "show")
	private Integer show;

	public GroupPermission(Integer group_id, String name, Integer order, Integer show) {
		super();
		this.group_id = group_id;
		this.name = name;
		this.order = order;
		this.show = show;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
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
}

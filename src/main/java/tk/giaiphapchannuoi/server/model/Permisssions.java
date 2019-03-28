package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="permissions")
public class Permisssions {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="group_id")
	@ManyToOne
	private Integer group_id;
	
	@Column(name="show")
	private Integer show;
	
	@Column(name="object_type")
	private Integer object_type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="code")
	private String code;
	
	@Column(name="order")
	private Integer order;

	public Permisssions(
			String name, 
			Integer group_id, 
			Integer show, 
			Integer object_type, 
			String description,
			String code, 
			Integer order) 
	{
		this.name = name;
		this.group_id = group_id;
		this.show = show;
		this.object_type = object_type;
		this.description = description;
		this.code = code;
		this.order = order;
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

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public Integer getObject_type() {
		return object_type;
	}

	public void setObject_type(Integer object_type) {
		this.object_type = object_type;
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
}

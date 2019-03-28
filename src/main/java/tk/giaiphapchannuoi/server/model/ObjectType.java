package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="object_type")
public class ObjectType {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	public ObjectType(String name) {
		this.name = name;
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
}

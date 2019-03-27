package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="foot_type")
public class FootType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

	public FootType(String name, String description) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

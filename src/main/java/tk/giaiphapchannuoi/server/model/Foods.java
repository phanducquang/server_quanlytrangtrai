package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="foods")
public class Foods {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="food_code")
	private String food_code;
	
	@Column(name="type_id")
	@ManyToOne
	private Integer type_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="use_for")
	private String use_for;
	
	@Column(name="guide")
	private String guide;
	
	@Column(name="description")
	private String description;
	
	@Column(name="images")
	private String images;

	public Foods(
			String food_code, 
			Integer type_id, 
			String name, 
			String use_for, 
			String guide, 
			String description,
			String images) 
	{
		this.food_code = food_code;
		this.type_id = type_id;
		this.name = name;
		this.use_for = use_for;
		this.guide = guide;
		this.description = description;
		this.images = images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFood_code() {
		return food_code;
	}

	public void setFood_code(String food_code) {
		this.food_code = food_code;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUse_for() {
		return use_for;
	}

	public void setUse_for(String use_for) {
		this.use_for = use_for;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}

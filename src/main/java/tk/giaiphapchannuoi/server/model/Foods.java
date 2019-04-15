package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="foods")
public class Foods extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="food_code")
	private String foodCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="type_id")
	private FoodType type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="use_for")
	private String useFor;
	
	@Column(name="guide")
	private String guide;
	
	@Column(name="description")
	private String description;
	
	@Column(name="images")
	private String images;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Foods() {
	}

	public Foods(String foodCode, FoodType type, String name, String useFor, String guide, String description, String images, Boolean delFlag) {
		this.foodCode = foodCode;
		this.type = type;
		this.name = name;
		this.useFor = useFor;
		this.guide = guide;
		this.description = description;
		this.images = images;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUseFor() {
		return useFor;
	}

	public void setUseFor(String useFor) {
		this.useFor = useFor;
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

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

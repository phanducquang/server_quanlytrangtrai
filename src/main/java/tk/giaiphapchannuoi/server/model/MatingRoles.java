package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="mating_roles")
public class MatingRoles extends Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="father_id")
	private Integer fatherId;
	
	@Column(name="mother_id")
	private Integer motherId;
	
	@Column(name="child_id")
	private Integer childId;
	
	@Column(name="birth_status_estimate")
	private Integer birthStatusEstimate;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MatingRoles() {
	}

	public MatingRoles(Integer fatherId, Integer motherId, Integer childId, Integer birthStatusEstimate, String description, Boolean delFlag) {
		this.fatherId = fatherId;
		this.motherId = motherId;
		this.childId = childId;
		this.birthStatusEstimate = birthStatusEstimate;
		this.description = description;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFatherId() {
		return fatherId;
	}

	public void setFatherId(Integer fatherId) {
		this.fatherId = fatherId;
	}

	public Integer getMotherId() {
		return motherId;
	}

	public void setMotherId(Integer motherId) {
		this.motherId = motherId;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public Integer getBirthStatusEstimate() {
		return birthStatusEstimate;
	}

	public void setBirthStatusEstimate(Integer birthStatusEstimate) {
		this.birthStatusEstimate = birthStatusEstimate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

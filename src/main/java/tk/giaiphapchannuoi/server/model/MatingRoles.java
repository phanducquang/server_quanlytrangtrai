package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="mating_roles")
public class MatingRoles extends Auditable implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="father_id")
	private Breeds fatherId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mother_id")
	private Breeds motherId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="child_id")
	private Breeds childId;
	
	@Column(name="birth_status_estimate")
	private Integer birthStatusEstimate;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MatingRoles() {
	}

	public MatingRoles(Breeds fatherId, Breeds motherId, Breeds childId, Integer birthStatusEstimate, String description, Boolean delFlag) {
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

	public Breeds getFatherId() {
		return fatherId;
	}

	public void setFatherId(Breeds fatherId) {
		this.fatherId = fatherId;
	}

	public Breeds getMotherId() {
		return motherId;
	}

	public void setMotherId(Breeds motherId) {
		this.motherId = motherId;
	}

	public Breeds getChildId() {
		return childId;
	}

	public void setChildId(Breeds childId) {
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

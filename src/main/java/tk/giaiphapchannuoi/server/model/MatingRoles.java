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
	private Breeds father;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mother_id")
	private Breeds mother;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="child_id")
	private Breeds child;
	
	@Column(name="birth_status_estimate")
	private Integer birthStatusEstimate;
	
	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public MatingRoles() {
	}

	public MatingRoles(Breeds father, Breeds mother, Breeds child, Integer birthStatusEstimate, String description, Boolean delFlag) {
		this.father = father;
		this.mother = mother;
		this.child = child;
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

	public Breeds getFather() {
		return father;
	}

	public void setFather(Breeds father) {
		this.father = father;
	}

	public Breeds getMother() {
		return mother;
	}

	public void setMother(Breeds mother) {
		this.mother = mother;
	}

	public Breeds getChild() {
		return child;
	}

	public void setChild(Breeds child) {
		this.child = child;
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

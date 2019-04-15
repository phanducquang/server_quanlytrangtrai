package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="issues_diseases")
public class IssuesDiseases extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="issue_id")
	private Issues issue;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="disease_id")
	private Diseases disease;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public IssuesDiseases() {
	}

	public IssuesDiseases(Issues issue, Diseases disease, Boolean delFlag) {
		this.issue = issue;
		this.disease = disease;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Issues getIssue() {
		return issue;
	}

	public void setIssue(Issues issue) {
		this.issue = issue;
	}

	public Diseases getDisease() {
		return disease;
	}

	public void setDisease(Diseases disease) {
		this.disease = disease;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

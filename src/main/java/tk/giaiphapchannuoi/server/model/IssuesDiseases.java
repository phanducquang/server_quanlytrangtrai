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
	
	@Column(name="issue_id")
	private Integer issueId;
	
	@Column(name="disease_id")
	private Integer diseaseId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public IssuesDiseases() {
	}

	public IssuesDiseases(Integer issueId, Integer diseaseId, Boolean delFlag) {
		this.issueId = issueId;
		this.diseaseId = diseaseId;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="issues_diseases")
public class IssuesDiseases {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="issue_id")
	@ManyToOne
	private Integer issue_id;
	
	@Column(name="disease_id")
	@ManyToOne
	private Integer disease_id;

	public IssuesDiseases(Integer issue_id, Integer disease_id) {
		super();
		this.issue_id = issue_id;
		this.disease_id = disease_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}

	public Integer getDisease_id() {
		return disease_id;
	}

	public void setDisease_id(Integer disease_id) {
		this.disease_id = disease_id;
	}
	
	
}

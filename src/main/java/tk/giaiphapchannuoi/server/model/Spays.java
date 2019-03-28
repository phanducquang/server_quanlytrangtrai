package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="spays")
public class Spays {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="pig_id")
	@ManyToOne
	private Integer pig_id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="log_id")
	private Integer log_id;
	
	@Column(name="description")
	private String description;

	public Spays(Integer pig_id, Date date, Integer log_id, String description) {
		this.pig_id = pig_id;
		this.date = date;
		this.log_id = log_id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPig_id() {
		return pig_id;
	}

	public void setPig_id(Integer pig_id) {
		this.pig_id = pig_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLog_id() {
		return log_id;
	}

	public void setLog_id(Integer log_id) {
		this.log_id = log_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

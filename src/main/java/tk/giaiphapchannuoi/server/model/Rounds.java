package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="rounds")
public class Rounds implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="from_")
	private Date from;
	
	@Column(name="to_")
	private Date to;
	
	@Column(name="number_of_pig")
	private Integer numberOfPig;
	
	@Column(name="birth_id")
	private Integer birthId;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Rounds() {
	}

	public Rounds(Date from, Date to, Integer numberOfPig, Integer birthId, Boolean delFlag) {
		this.from = from;
		this.to = to;
		this.numberOfPig = numberOfPig;
		this.birthId = birthId;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public Integer getNumberOfPig() {
		return numberOfPig;
	}

	public void setNumberOfPig(Integer numberOfPig) {
		this.numberOfPig = numberOfPig;
	}

	public Integer getBirthId() {
		return birthId;
	}

	public void setBirthId(Integer birthId) {
		this.birthId = birthId;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

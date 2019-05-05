package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="rounds")
public class Rounds extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="from_")
	private Date from;
	
	@Column(name="to_")
	private Date to;
	
//	@Column(name="number_of_pig")
//	private Integer numberOfPig;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Rounds() {
	}

	public Rounds(Date from, Date to, Boolean delFlag) {
		this.from = from;
		this.to = to;
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

//	public Integer getNumberOfPig() {
//		return numberOfPig;
//	}
//
//	public void setNumberOfPig(Integer numberOfPig) {
//		this.numberOfPig = numberOfPig;
//	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

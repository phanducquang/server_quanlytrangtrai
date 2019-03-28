package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="rounds")
public class Rounds {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="from")
	private Date from;
	
	@Column(name="to")
	private Date to;
	
	@Column(name="number_of_pig")
	private Integer number_of_pig;
	
	@Column(name="birth_id")
	@ManyToOne
	private Integer birth_id;

	public Rounds(Date from, Date to, Integer number_of_pig, Integer birth_id) {
		this.from = from;
		this.to = to;
		this.number_of_pig = number_of_pig;
		this.birth_id = birth_id;
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

	public Integer getNumber_of_pig() {
		return number_of_pig;
	}

	public void setNumber_of_pig(Integer number_of_pig) {
		this.number_of_pig = number_of_pig;
	}

	public Integer getBirth_id() {
		return birth_id;
	}

	public void setBirth_id(Integer birth_id) {
		this.birth_id = birth_id;
	}
	
}

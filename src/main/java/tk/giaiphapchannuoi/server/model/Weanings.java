package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="weanings")
public class Weanings {
	
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
	@ManyToOne
	private Integer log_id;
	
	@Column(name="sum_child_weight")
	private Float sum_child_weight;
	
	@Column(name="quantity")
	private Integer quantity;

	public Weanings(
			Integer pig_id, 
			Date date, 
			Integer log_id,
			Float sum_child_weight, 
			Integer quantity
			) 
	{
		this.pig_id = pig_id;
		this.date = date;
		this.log_id = log_id;
		this.sum_child_weight = sum_child_weight;
		this.quantity = quantity;
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

	public Float getSum_child_weight() {
		return sum_child_weight;
	}

	public void setSum_child_weight(Float sum_child_weight) {
		this.sum_child_weight = sum_child_weight;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}

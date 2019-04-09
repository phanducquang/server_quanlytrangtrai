package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="issues")
public class Issues implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="level")
	private Integer level;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="lesions")
	private String lesions;
	
	@Column(name="description")
	private String description;

	public Issues(Integer level, String symbol, String lesions, String description) {
		super();
		this.level = level;
		this.symbol = symbol;
		this.lesions = lesions;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLesions() {
		return lesions;
	}

	public void setLesions(String lesions) {
		this.lesions = lesions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

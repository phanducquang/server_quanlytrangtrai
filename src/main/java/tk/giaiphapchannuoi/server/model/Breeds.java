package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="breeds")
public class Breeds {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	@OneToMany
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="line_code")
	private String line_code;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="code")
	private String code;
	
	@Column(name="level")
	private Integer level;
	
	@Column(name="line")
	private Integer line;
	
	@Column(name="description")
	private String description;

	public Breeds(
			String name, 
			String line_code, 
			String symbol, 
			String code, 
			Integer level, 
			Integer line,
			String description) 
	{
		this.name = name;
		this.line_code = line_code;
		this.symbol = symbol;
		this.code = code;
		this.level = level;
		this.line = line;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine_code() {
		return line_code;
	}

	public void setLine_code(String line_code) {
		this.line_code = line_code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

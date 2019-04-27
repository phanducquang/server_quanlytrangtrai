package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="permissions")
public class Permissions extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Column(name="code")
	private String code;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "screen_id")
	private Screens screen;

	@Column(name="description")
	private String description;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Permissions() {
	}

	public Permissions(String name, String code, Screens screen, String description, Boolean delFlag) {
		this.name = name;
		this.code = code;
		this.screen = screen;
		this.description = description;
		this.delFlag = delFlag;
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

	public Screens getScreen() {
		return screen;
	}

	public void setScreen(Screens screen) {
		this.screen = screen;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

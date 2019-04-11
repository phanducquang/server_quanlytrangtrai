package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="activate")
	private Integer activate;
	
	@Column(name="language")
	private String language;
	
	@Column(name="theme")
	private String theme;
	
	@Column(name="last_activate")
	private Date lastActivate;
	
	@Column(name="login")
	private Integer login;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Users() {
	}

	public Users(String username, String password, String email, Integer employeeId, Integer activate, String language, String theme, Date lastActivate, Integer login, Boolean delFlag) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.employeeId = employeeId;
		this.activate = activate;
		this.language = language;
		this.theme = theme;
		this.lastActivate = lastActivate;
		this.login = login;
		this.delFlag = delFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getActivate() {
		return activate;
	}

	public void setActivate(Integer activate) {
		this.activate = activate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getLastActivate() {
		return lastActivate;
	}

	public void setLastActivate(Date lastActivate) {
		this.lastActivate = lastActivate;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}

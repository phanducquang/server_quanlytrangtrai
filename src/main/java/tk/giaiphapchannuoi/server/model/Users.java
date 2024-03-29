package tk.giaiphapchannuoi.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users extends Auditable implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id")
	private Employees employee;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roles_id")
	private Roles role;
	
	@Column(name="activate")
	private Integer activate;
	
	@Column(name="language")
	private String language;
	
	@Column(name="token_notification")
	private String tokenNotification;
	
	@Column(name="last_activate")
	private Date lastActivate;
	
	@Column(name="login")
	private Integer login;

	@Column(name = "del_flag")
	private Boolean delFlag;

	public Users() {
	}

	public Users(String username, String password, String email, Employees employee, Roles role, Integer activate, String language, String tokenNotification, Date lastActivate, Integer login, Boolean delFlag) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.employee = employee;
		this.role = role;
		this.activate = activate;
		this.language = language;
		this.tokenNotification = tokenNotification;
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

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
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

	public String getTokenNotification() {
		return tokenNotification;
	}

	public void setTokenNotification(String tokenNotification) {
		this.tokenNotification = tokenNotification;
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

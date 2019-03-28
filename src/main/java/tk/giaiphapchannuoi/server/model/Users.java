package tk.giaiphapchannuoi.server.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	@OneToMany
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="employee_id")
	@ManyToOne
	private Integer employee_id;
	
	@Column(name="activate")
	private Integer activate;
	
	@Column(name="language")
	private String language;
	
	@Column(name="theme")
	private String theme;
	
	@Column(name="last_activate")
	private Date last_activate;
	
	@Column(name="login")
	private Integer login;

	public Users(
			String username, 
			String password, 
			String email, 
			Integer employee_id, 
			Integer activate, 
			String language,
			String theme, 
			Date last_activate, 
			Integer login) 
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.employee_id = employee_id;
		this.activate = activate;
		this.language = language;
		this.theme = theme;
		this.last_activate = last_activate;
		this.login = login;
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

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
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

	public Date getLast_activate() {
		return last_activate;
	}

	public void setLast_activate(Date last_activate) {
		this.last_activate = last_activate;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}
}

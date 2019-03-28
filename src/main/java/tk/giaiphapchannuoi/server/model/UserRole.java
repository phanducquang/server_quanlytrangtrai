package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	@ManyToOne
	private Integer user_id;
	
	@Column(name="role_id")
	@ManyToOne
	private Integer role_id;

	public UserRole(Integer user_id, Integer role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
}

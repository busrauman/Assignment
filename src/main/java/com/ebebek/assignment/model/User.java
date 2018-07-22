package com.ebebek.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	private Long id;
	
	@NotNull(message="username can not be empty")
	@Column(name="username")
	@Size(min=3,message="Username should have at least 3 characters ")
	@NotBlank(message="Username can not be empty and can not include space characters")
	private String username;
	
	@NotNull(message="Email can not be empty")
	@Column(name="email")
	@NotBlank(message="Email can not be empty and can not include space characters")
	@Email(message = "Please provide a valid e-mail")
	private String email;
	
	@NotNull(message="Password can not be empty")
	@Column(name="password")
    @Size(min=7 ,message="Password should have at least 7 characters")
	@NotBlank(message="Password can not be empty and can not include space characters")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$",message="Password should have include at least"
			+ "an uppercase and lowercace ")
	private String password;
	
	@Transient
	@NotNull(message="Password Confirm can not be empty")
    @Size(min=7 ,message="Password should have at least 7 characters")
	
	private String confirmPassword;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}

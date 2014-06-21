package fr.upmc.aar.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class User {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key userKey;
	
	@Persistent
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String lastName;
	
	@Persistent
	private String firstName;
	
	@Persistent
	private Date birtDate;
	
	@Persistent
	private Date inscrDate;
	
	@Persistent
	private String mail;
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Key getUserKey() {
		return userKey;
	}

	public void setUserKey(Key userKey) {
		this.userKey = userKey;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}

	public Date getInscrDate() {
		return inscrDate;
	}

	public void setInscrDate(Date inscrDate) {
		this.inscrDate = inscrDate;
	}

	public String html()
	{
		return 
		"<p>name  : " + lastName + " " + firstName + "</p>" +
		"<p>username  : " + username + ", password " + password + "</p><br/>"
		;
	}

}

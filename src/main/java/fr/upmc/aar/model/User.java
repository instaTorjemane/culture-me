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
	private Key keyUser;
	
	@Persistent
	private String username;
	
	@Persistent
	private String password;
	
	@Persistent
	private String nom;
	
	@Persistent
	private String prenom;
	
	@Persistent
	private int age;
	
	@Persistent
	private Date dateInscription;
	
	
	/*
	 * GET/SET 
	 */
	

	public Key getKeyUser() {
		return keyUser;
	}


	public void setKeyUser(Key keyUser) {
		this.keyUser = keyUser;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	
	
	
	public String html()
	{
		return 
		"<p>name  : " + nom + " " + prenom + "</p><br/>" +
		"<p>username  : " + username + ", password " + password + "</p><br>"
		;
	}

}

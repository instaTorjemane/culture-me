package fr.upmc.aar.model;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Product {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key keyProduct;
	
	@Persistent
	private String nom;
	
	@Persistent
	private Category categoryProduct;
	
	@Persistent
	private List<Comment> comments;
	
	@Persistent 
	private Date dateParution;


	public Key getKeyProduct() {
		return keyProduct;
	}


	/*
	 * GET/SET
	 */
	
	public void setKeyProduct(Key keyProduct) {
		this.keyProduct = keyProduct;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Category getCategoryProduct() {
		return categoryProduct;
	}


	public void setCategoryProduct(Category categoryProduct) {
		this.categoryProduct = categoryProduct;
	}


	public Date getDateParution() {
		return dateParution;
	}


	public void setDateParution(Date dateParution) {
		this.dateParution = dateParution;
	}
	
	
}

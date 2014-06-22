package fr.upmc.aar.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Comment {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key commentKey;
	
	@Persistent
	private String username;
	
	@Persistent
	private Date commentDate;
	
	@Persistent
	private String content;
	
	@Persistent
	private Float mark;

	public Key getCommentKey() {
		return commentKey;
	}

	public void setCommentKey(Key commentKey) {
		this.commentKey = commentKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}


	
}

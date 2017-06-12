package com.cisco.cmadt9blogger.api;

import java.util.Date;
import java.util.List;

//import javax.persistence.OneToOne;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.PrePersist;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;

@Entity
public class Blog {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String blogId = new ObjectId().toHexString();

	private String userId;

	private String title;
	
	private Date postedDate;
	
	private String description;

//	@OneToMany(mappedBy="blog",cascade=CascadeType.REMOVE)
	private List<BlogComment> comments;

	public Blog() {
		super();
	}

	public Blog(String blogId, String userId, String title, String description/*, List<BlogComment> comments*/) {
		super();
		this.blogId = blogId;
		this.userId = userId;
		this.title = title;
		this.description = description;
		//this.comments = comments;
	}

	@PrePersist
	protected void onCreate() {
		postedDate = new Date();
	}
	
	//For updating blog
	//	  @PreUpdate
	//	  protected void onUpdate() {
	//	    updated = new Date();
	//	  }

//	public String getBlogIdString() {
//		System.out.println("Blog getBlogId :"+blogId);
//		System.out.println("Blog getBlogId hex :"+blogId.toHexString());
//		return blogId.toHexString();
//	}


	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	
	public String getBlogId() {
		return blogId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


}

package com.cisco.cmadt9blogger.data;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;

import com.cisco.cmadt9blogger.api.Blog;

public class MongoBlogDAO extends BasicDAO<Blog, String> implements BlogDAO {

	public MongoBlogDAO(Class<Blog> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	
	public void createBlog(Blog blog) {
		save(blog);

	}

	public Blog readBlog(String blogId) {
		//ObjectId objId = new ObjectId(blogId);
		//return get(objId);
		return get(blogId);
		
	}

	public List<Blog> getAllBlogs(int offset, int pageSize, String searchStr, String userFilter) {
		Query<Blog> query = createQuery();
		System.out.println("MongoBlogDAO getAllBlogs offset :"+offset);
		System.out.println("MongoBlogDAO getAllBlogs pageSize :"+pageSize);
		System.out.println("MongoBlogDAO getAllBlogs searchStr :"+searchStr);
		System.out.println("MongoBlogDAO getAllBlogs searchStr :"+searchStr);
		System.out.println("MongoBlogDAO getAllBlogs userFilter-- :"+userFilter);
		String sortingParam = "-postedDate";
		if(searchStr != null && !searchStr.trim().equals(""))
		{
			System.out.println("MongoBlogDAO getAllBlogs createQuery TP1");
			Criteria searchCriteria = createQuery().criteria("title").containsIgnoreCase(searchStr);
			query.and(searchCriteria);
		}
		if(userFilter != null  && !userFilter.trim().equals("")){
			System.out.println("MongoBlogDAO getAllBlogs createQuery TP2");
			Criteria userCriteria = createQuery().criteria("userId").equalIgnoreCase(userFilter);
			query.and(userCriteria);
		}
		offset = offset * pageSize;
		return query.order(sortingParam).asList(new FindOptions().skip(offset).limit(pageSize));
	}

	public long getBlogCount(String searchStr, String userFilter) {
		Query<Blog> query = createQuery();
		if(searchStr != null && !searchStr.trim().equals(""))
		{
			Criteria searchCriteria = createQuery().criteria("title").containsIgnoreCase(searchStr);
			query.and(searchCriteria);
		}
		if(userFilter != null  && !userFilter.trim().equals("")){
			Criteria userCriteria = createQuery().criteria("userId").equalIgnoreCase(userFilter);
			query.and(userCriteria);
		}
		return query.count();
	}

	public void deleteBlog(String blogId) {
		//ObjectId objId = new ObjectId(blogId);
		//deleteById(objId);
		deleteById(blogId);
	}
}

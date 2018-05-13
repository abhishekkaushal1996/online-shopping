package com.mabhi.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mabhi.shoppingbackend.dao.CategoryDAO;
import com.mabhi.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="FROM Category WHERE active= :active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	
	@Override
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	
	/*
	 * for getting the single category
	 */
	@Override
	public boolean add(Category category) {
		
		try {
			// add the category to database
			
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	/*
	 * update a single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to database
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		try {
			// add the category to database
			category.setActive(false);
			
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

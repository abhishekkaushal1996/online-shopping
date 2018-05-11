package com.mabhi.shoppingbackend.dao;

import java.util.List;

import com.mabhi.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	 Category get(int id);
	 }

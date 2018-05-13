package com.mabhi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mabhi.shoppingbackend.dao.CategoryDAO;
import com.mabhi.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mabhi.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { category=new Category();
	 * category.setName("Mobile");
	 * category.setDescription("This is the mobile category");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * assertEquals("Successfully added the category in to the list",true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category=categoryDAO.get(4);
	 * 
	 * assertEquals("Successfully fetched the category in to the list","Mobile",
	 * category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category=categoryDAO.get(4);
	 * 
	 * category.setName("Laptop");
	 * assertEquals("Successfully updated the category in to the list",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category=categoryDAO.get(4);
	 * 
	 * assertEquals("Successfully deleted the category in to the list",true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() { category=categoryDAO.get(4);
	 * 
	 * assertEquals("Successfully fetched the list of category in to the list",1,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDOperation() {

		// to add a category
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is the mobile category");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added the category in to the list", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is the television category");
		category.setImageURL("CAT_22.png");

		assertEquals("Successfully added the category in to the list", true, categoryDAO.add(category));

		// to update a category

		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated the category in to the list", true, categoryDAO.update(category));

		// to update a category

		category = categoryDAO.get(2);

		assertEquals("Successfully deleted the category in to the list", true, categoryDAO.delete(category));

		// to fetch all active list

		category = categoryDAO.get(2);
		assertEquals("Successfully fetched the list of category in to the list", 1, categoryDAO.list().size());
	}
}

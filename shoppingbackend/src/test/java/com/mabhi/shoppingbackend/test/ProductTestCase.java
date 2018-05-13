package com.mabhi.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mabhi.shoppingbackend.dao.ProductDAO;
import com.mabhi.shoppingbackend.dto.Category;
import com.mabhi.shoppingbackend.dto.Product;

public class ProductTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mabhi.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDOperation() {

		// to add a category
		product = new Product();
		product.setName("Oppo selfie S3");
		product.setBrand("Oppo");
		product.setDescription("This is the mobile category");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);

		assertEquals("Successfully added the product in to the list", true, productDAO.add(product));


		// to update a category

		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Successfully updated the product in to the list", true, productDAO.update(product));

		// to update a category

		assertEquals("Successfully deleted the product in to the list", true, productDAO.delete(product));

		// to fetch all active list

		product = productDAO.get(2);
		assertEquals("Successfully fetched the list of category in to the list", 6, productDAO.list().size());
	}*/
	@Test
	public void testListActiveProducts() {
		assertEquals("Successfully fetched the list of active products in to the list", 5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Successfully fetched the list of active products in to the list", 3, 
				productDAO.listActiveProductsByCategory(3).size());
	}
	
	@Test
	public void latestActiveProducts() {
		assertEquals("Successfully fetched the list of active products in to the list", 3, 
				productDAO.getLatestActiveProducts(3).size());
	}
	
}

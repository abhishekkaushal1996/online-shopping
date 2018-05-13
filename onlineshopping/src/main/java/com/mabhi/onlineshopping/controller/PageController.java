package com.mabhi.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mabhi.onlineshopping.exception.ProductNotFoundException;
import com.mabhi.shoppingbackend.dao.CategoryDAO;
import com.mabhi.shoppingbackend.dao.ProductDAO;
import com.mabhi.shoppingbackend.dto.Category;
import com.mabhi.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/index", "/home" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "home");
		mv.addObject("userClickHome", true);
		
		logger.info("Inside page controller from index-INFO");
		logger.debug("Inside page controller from index-DEBUG");
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * To show all products
	 */

	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}

	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");
		Category category = null;

		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		// passing the list of categories

		// to fetch single category

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		return mv;
	}
	
	@RequestMapping(value = "show/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable("id") int id) throws ProductNotFoundException {

		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		//update view counts 
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
	}

	/*
	 * @RequestMapping(value="/test") //public ModelAndView
	 * test(@RequestParam("greeting")String greeting) { // it should be present
	 * public ModelAndView test(@RequestParam(value="greeting",
	 * required=false)String greeting) { if(greeting==null) {
	 * greeting="hello there"; } ModelAndView mv=new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv; }
	 * 
	 * 
	 * @RequestMapping(value="/test/{greeting}") //public ModelAndView
	 * test(@RequestParam("greeting")String greeting) { // it should be present
	 * public ModelAndView test(@PathVariable(value="greeting",
	 * required=false)String greeting) { if(greeting==null) {
	 * greeting="hello there"; } ModelAndView mv=new ModelAndView("page");
	 * mv.addObject("greeting",greeting); return mv; }
	 */
}

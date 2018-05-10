package com.mabhi.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	
	@RequestMapping(value= {"/","/index","/home"})
	public ModelAndView index() {
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting","welcome to web MVC");
		return mv;
	}
	/*
	@RequestMapping(value="/test")
	//public ModelAndView test(@RequestParam("greeting")String greeting) {    // it should be present
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		if(greeting==null) {
			greeting="hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	
	@RequestMapping(value="/test/{greeting}")
	//public ModelAndView test(@RequestParam("greeting")String greeting) {    // it should be present
	public ModelAndView test(@PathVariable(value="greeting", required=false)String greeting) {
		if(greeting==null) {
			greeting="hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}*/
}
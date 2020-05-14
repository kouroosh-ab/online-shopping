package net.kzn.onlineshopping1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend1.dao.CategoryDAO;
import net.kzn.shoppingbackend1.dto.Category;

@Controller
public class PageController 
{
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() 
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "home");
		//Passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
		
	}
	
	
	/*                                 Request Mapping for about                                              */
	@RequestMapping(value="/about" )
	public ModelAndView about() 
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	
	
	/*                                 Request Mapping for contact                                            */
	@RequestMapping(value="/contact" )
	public ModelAndView contact() 
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
		
	}
	

//                                   Method to load all products and based on category
	@RequestMapping(value= ("/show/all/products"))
	public ModelAndView showAllProducts() 
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		//Passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;		
	}
//	
	@RequestMapping(value= ("/show/category/{id}/products"))
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) 
	{
	//categoryDAO to fetch a single category
		Category category=null;
		category=categoryDAO.get(id);
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", category.getName());
		//Passing the list of category
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category",category); 
		mv.addObject("userClickCategoryProducts", true);
		return mv;
		
	}
	
}//end of front controller class

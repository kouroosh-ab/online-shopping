package net.kzn.onlineshopping1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping1.exception.ProductNotFoundException;
import net.kzn.shoppingbackend1.dao.CategoryDAO;
import net.kzn.shoppingbackend1.dao.ProductDAO;
import net.kzn.shoppingbackend1.dto.Category;
import net.kzn.shoppingbackend1.dto.Product;

@Controller
public class PageController 
{
	
	@Autowired 
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	
	@RequestMapping(value= {"/","/home","index"})
	public ModelAndView index() 
	{
	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "home");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
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
//Controller for show single product view
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
	ModelAndView mv=new ModelAndView("page");	
		Product product=productDAO.get(id);
		if (product==null) throw new ProductNotFoundException();
		//update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//------------------------------
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);	
		
	return mv;
	}//end of controller for sigle product view





}//end of front controller class

package net.kzn.shoppingbackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend1.dao.CategoryDAO;
import net.kzn.shoppingbackend1.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend1");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}//end of init class
//	@Test
//	public void testAddCategory() {
//		category=new Category();
//		category.setName("Monitor");
//		category.setDescription("This is some description for television");
//		category.setImageURL("Cat_41.png");
//		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
//				
//	}
	
//	@Test
//	public void testGetCategory (){
//		
//		category=categoryDAO.get(3);
//		assertEquals("Successfully fetched a single category from the table","Mobile",category.getName());
//		
//		
//	}
//	@Test
//	public void testUpdateCategory (){
//		
//		category=categoryDAO.get(3);
//		category.setName("TV");
//		assertEquals("Successfully update a single category from the table",true,categoryDAO.update(category));
//		
//		
//	}
//	@Test
//	public void testDeleteCategory (){
//		
//		category=categoryDAO.get(3);
//		assertEquals("Successfully delete a single category from the table",true,categoryDAO.delete(category));
//		
//		
//	}
//	
@Test
public void testCRUDCategory() {
	//add operation
	category=new Category();
	category.setName("Laptop");
	category.setDescription("This is some description for laptop");
	category.setImageURL("Cat_1.png");
	assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	category=new Category();
	category.setName("Television");
	category.setDescription("This is some description for television");
	category.setImageURL("Cat_ .png");
	assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	//fetching and updating the category
	category=categoryDAO.get(2);
	category.setName("TV");
	assertEquals("Successfully update a single category from the table",true,categoryDAO.update(category));
	//delete the category
	assertEquals("Successfully delete a single category from the table",true,categoryDAO.delete(category));
	//fetching the list
	assertEquals("Successfully fetched the list of active category from table",6,categoryDAO.list().size());
	
	
	
	
	
	
	
	
}

}//end of test class

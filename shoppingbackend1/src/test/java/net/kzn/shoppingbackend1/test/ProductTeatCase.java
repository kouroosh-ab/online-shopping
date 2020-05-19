package net.kzn.shoppingbackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend1.dao.ProductDAO;
import net.kzn.shoppingbackend1.dto.Product;

public class ProductTeatCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend1");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

//	@Test
//	public void testCRUDProduct() {
//		//create operation
//		product =new Product();
//		product.setName("oppo Selfi S53");
//		product.setBrand("Oppo");
//		product.setDescription("This is some description for oopo mobile phones!");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		assertEquals("Somthing went wrong when inserting a new product!",true,productDAO.add(product));
//		
//		//reading and updating the product
//		product=productDAO.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Somthing went wrong while updatin the existing record",true,productDAO.update(product));
//		assertEquals("somthing went wrong while deleting the existing record",true,productDAO.delete(product));
//		assertEquals("somthign went wrong while fetching the list of products",7,productDAO.list().size());

//	}//end of test crud method
	@Test
	public void testListActiveProducts() {

		assertEquals("somthing went wrong while fetching the list of products", 7,
				productDAO.listActiveProducts().size());

	}

	@Test
	public void testListActiveProductsCategory() {

		assertEquals("somthing went wrong while fetching the list of products", 5,
				productDAO.listActiveProductsByCategory(3).size());
		assertEquals("somthing went wrong while fetching the list of products", 2,
				productDAO.listActiveProductsByCategory(1).size());

	}
	@Test
	public void testGetLatestActiveProduct() {
		
		
		assertEquals("somthing went wrong while fetching the list of products",3,
				productDAO.getLatestActiveProducts(3).size());
		
		
	}

}// end of test product class

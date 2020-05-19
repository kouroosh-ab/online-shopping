package net.kzn.shoppingbackend1.dao;

import java.util.List;

import net.kzn.shoppingbackend1.dto.Category;

public interface CategoryDAO 
{
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

	

}//											end of category interface 

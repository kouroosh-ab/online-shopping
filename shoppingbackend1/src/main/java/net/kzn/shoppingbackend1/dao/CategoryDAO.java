package net.kzn.shoppingbackend1.dao;

import java.util.List;

import net.kzn.shoppingbackend1.dto.Category;

public interface CategoryDAO 
{
	List<Category> list();

	Category get(int id);

}//											end of category interface 

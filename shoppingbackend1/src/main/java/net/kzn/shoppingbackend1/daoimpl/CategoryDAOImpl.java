package net.kzn.shoppingbackend1.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbackend1.dao.CategoryDAO;
import net.kzn.shoppingbackend1.dto.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();

	static {
//                                     adding first categoey
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some description for television");
		category.setImageURL("Cat_1.png");
		categories.add(category);
//  									adding second categoey
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some description for mobile");
		category.setImageURL("Cat_2.png");
		categories.add(category);
//      								adding third categoey
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop");
		category.setImageURL("Cat_3.png");
		categories.add(category);

	}// end of static block

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category:categories) 
		{
			if (category.getId()==id)
				return category;
		}
		return null;
	}

}// end of class

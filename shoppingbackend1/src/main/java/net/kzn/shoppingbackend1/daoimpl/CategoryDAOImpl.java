package net.kzn.shoppingbackend1.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend1.dao.CategoryDAO;
import net.kzn.shoppingbackend1.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
//	private static List<Category> categories = new ArrayList<>();

//	static {
////                                     adding first categoey
//		Category category = new Category();
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("This is some description for television");
//		category.setImageURL("Cat_1.png");
//		categories.add(category);
////  									adding second categoey
//		category = new Category();
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("This is some description for mobile");
//		category.setImageURL("Cat_2.png");
//		categories.add(category);
////      								adding third categoey
//		category = new Category();
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("This is some description for laptop");
//		category.setImageURL("Cat_3.png");
//		categories.add(category);
//
//	}// end of static block

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCatefory="FROM Category WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCatefory);
		query.setParameter("active", true);
		return query.getResultList();
	}
//Getting a single category based on id
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	
	public boolean add(Category category) {
		try {
			// Add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			// Update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		return update(category);
	}

}// end of class

package net.kzn.shoppingbackend1.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend1.dao.ProductDAO;
import net.kzn.shoppingbackend1.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		try {

			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProduct = "From Product WHERE active=:active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProduct, Product.class)
				.setParameter("active", true).getResultList();

	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		String selectActiveProductsByCategory="FROM Product WHERE active=:active AND categoryId=:categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
				
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE active=:active ORDER BY id",Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
				
				
				
	}

}

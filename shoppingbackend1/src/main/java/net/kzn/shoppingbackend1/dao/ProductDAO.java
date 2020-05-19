package net.kzn.shoppingbackend1.dao;

import java.util.List;

import net.kzn.shoppingbackend1.dto.Product;

public interface ProductDAO {
Product get(int id);
List<Product> list();
boolean add(Product product);
boolean update(Product product);
boolean delete(Product product);

//bussiness methods
List<Product> listActiveProducts();
List<Product> listActiveProductsByCategory(int categoryId);
List<Product> getLatestActiveProducts(int count);



}//end of interface

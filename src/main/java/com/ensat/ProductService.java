package com.ensat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

	

}

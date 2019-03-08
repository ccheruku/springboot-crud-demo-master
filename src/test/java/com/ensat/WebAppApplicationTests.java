package com.ensat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootWebApplication.class)
@WebAppConfiguration
@EnableJpaRepositories( basePackageClasses = ProductRepository.class )
@SpringBootTest
public class WebAppApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void contextLoads() {
	}
	
	/*@Test
	public void productSave() {
	    // given
		Product product = new Product();
		product.setId(10);
		product.setName("Productnme");
		product.setPrice(new BigDecimal(31));
		productRepository.save(product);
	    // when
	    Employee found = employeeRepository.findByName(alex.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(alex.getName());
	}

	@Test
    public void getProductById() {
		Product product = new Product();
		product.setId(4);
		product.setName("product1");
		product.setPrice(new BigDecimal(31));
		Product retrievedProdcut = productRepository.findOne(product.getId());
		 assertThat(retrievedProdcut.getName())
	      .isEqualTo(product.getName());
    }*/
}

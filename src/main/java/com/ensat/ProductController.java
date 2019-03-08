package com.ensat;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Product controller.
 */
@Controller
public class ProductController {

	private ProductService productService;
	private static final int[] PAGE_SIZES = { 5, 10, 20};
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/* *//**
			 * List all products.
			 *
			 * @param model
			 * @return
			 *//*
			 * @RequestMapping(value = "/products", method = RequestMethod.GET)
			 * public String list(Model model) { model.addAttribute("products",
			 * productService.listAllProducts());
			 * System.out.println("Returning rpoducts:"); return "products"; }
			 */

	 @RequestMapping(value = "/products", method = RequestMethod.GET)
	    public String list(Model model) {
	        model.addAttribute("products", productService.listAllProducts());
	        System.out.println("Returning rpoducts:");
	        return "products";
	}

	
	/*@GetMapping("/products")
	public String list(Model model,@RequestParam int page,@RequestParam int size, @RequestParam String sortBy,@RequestParam Sort.Direction sortDirection){
	    Pageable pageable = new PageRequest(page, size, sortDirection, sortBy);
		Page<Product> productPage = productService.findAll(pageable);
		PageWrapper<Product> page1 = new PageWrapper<Product>(productPage, "/products");
		model.addAttribute("products", page.getContent());
		model.addAttribute("products", productPage.getContent());
		model.addAttribute("page", page1);
		return "products";

	}*/
	/**
	 * View a specific product by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	// Afficher le formulaire de modification du Product
	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	/**
	 * New product.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	/* *//**
			 * Save product to database.
			 *
			 * @param product
			 * @return
			 *//*
			 * @RequestMapping(value = "product", method = RequestMethod.POST)
			 * public String saveProduct(Product product) {
			 * productService.saveProduct(product); return "redirect:/product/"
			 * + product.getId(); }
			 */

	/**
	 * Save product to database.
	 *
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("BINDING RESULT ERROR");
			return "productform";
		}
		productService.saveProduct(product);
		// return "redirect:/product/" + product.getId();
		return "redirect:/product/" + product.getId();
	}

	/**
	 * Delete product by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("product/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}

}

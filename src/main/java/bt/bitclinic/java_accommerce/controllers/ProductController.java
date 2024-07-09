package bt.bitclinic.java_accommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bt.bitclinic.java_accommerce.dto.ProductDTO;
import bt.bitclinic.java_accommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController{
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<ProductDTO> all() {
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ProductDTO byId(@PathVariable Long id) {
		return service.findById(id);
	}
}

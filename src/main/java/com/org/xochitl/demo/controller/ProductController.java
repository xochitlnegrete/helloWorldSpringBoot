package com.org.xochitl.demo.controller;

import com.org.xochitl.demo.entity.Product;
import com.org.xochitl.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts()   {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)    {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product)  {
        return productService.saveProduct(product);
    }

    @PutMapping
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)   {
        Product existingProduct = productService.getProductById(id);

        if(existingProduct != null) {
            existingProduct.setName(Product.getName());
            existingProduct.setPrice(Product.getPrice());

            return productService.saveProduct(existingProduct);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id)    {
        productService.deleteProduct(id);
    }
}

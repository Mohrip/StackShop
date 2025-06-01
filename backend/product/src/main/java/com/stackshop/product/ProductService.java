package com.stackshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseGet(() -> {
                        Category newCategory = new Category();
                        newCategory.setName(product.getCategory().getName() != null ? product.getCategory().getName() : "Default Category");
                        newCategory.setDescription(product.getCategory().getDescription() != null ? product.getCategory().getDescription() : "Default Description");
                        return categoryRepository.save(newCategory);
                    });
            product.setCategory(category);
        } else if (product.getCategory() != null) {
            Category newCategory = categoryRepository.save(product.getCategory());
            product.setCategory(newCategory);
        } else {
            throw new RuntimeException("Category information is required");
        }

        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setAvailableQuantity(product.getAvailableQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
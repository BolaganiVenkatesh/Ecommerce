package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.dto.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
    ProductResponse getProductById(Long id);
    List<ProductResponse> getAllProducts();
}

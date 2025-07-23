package net.java.backend.beauty_service;

import net.java.backend.beauty_domain.Product;
import net.java.backend.beauty_dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    void deleteProductById(Long id);
    ProductDto updateProduct(Long id, ProductDto productDto);
}

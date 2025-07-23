package net.java.backend.mapper;

import net.java.backend.beauty_domain.Product;
import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_dto.ProductDto;
import net.java.backend.beauty_repository.UserJPARepository;
import net.java.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final UserJPARepository userRepository;

    @Autowired
    public ProductMapper(UserJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    public Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        if (productDto.getUserId() != null) {
            User user = userRepository.findById(productDto.getUserId())
                    .orElseThrow(() -> new ResourceNotFoundException("User with id " + productDto.getUserId() + " not found"));
            product.setUser(user);
        }
        return product;
    }

    public ProductDto mapToProductDto(Product product) {
        Long userId = null;
        if (product.getUser() != null) {
            userId = product.getUser().getId();
        }
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getCategory(),
                product.getPrice(),
                userId
        );
    }
}
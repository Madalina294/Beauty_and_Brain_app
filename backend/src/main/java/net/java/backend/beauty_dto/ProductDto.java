package net.java.backend.beauty_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.java.backend.beauty_domain.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private String category;
    private Double price;
    private Long userId;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }
    public Long getUserId() { return userId; }
}

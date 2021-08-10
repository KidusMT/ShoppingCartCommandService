package project.swa.ShoppingCartService.service;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String productNumber;
    private String name;
    private Double price;
    private String description;
    private StockDTO stock;
    private List<ReviewDTO> reviews;

    public ProductDTO(String productNumber, String name, Double price, String description, StockDTO stock, List<ReviewDTO> reviews) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.reviews = reviews;
    }
}

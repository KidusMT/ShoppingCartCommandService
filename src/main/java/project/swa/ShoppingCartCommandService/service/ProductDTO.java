package project.swa.ShoppingCartCommandService.service;

import java.util.List;

//@Data
//@NoArgsConstructor
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

    public ProductDTO() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StockDTO getStock() {
        return stock;
    }

    public void setStock(StockDTO stock) {
        this.stock = stock;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }
}

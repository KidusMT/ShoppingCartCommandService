package project.swa.ShoppingCartService.service;

import lombok.Data;

@Data
public class CartLineDTO {
    private int quantity;
    private ProductDTO product;

    public CartLineDTO(int quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }
}

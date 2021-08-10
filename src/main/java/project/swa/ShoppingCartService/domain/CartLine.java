package project.swa.ShoppingCartService.domain;

import lombok.Data;
import project.swa.ShoppingCartService.service.ProductDTO;

@Data
public class CartLine {
    private int quantity;
    private ProductDTO product;

    public CartLine(int quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }
}

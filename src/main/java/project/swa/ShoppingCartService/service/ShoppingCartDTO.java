package project.swa.ShoppingCartService.service;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDTO {
    private String shoppingCartNumber;
    private List<CartLineDTO> cartLineDTOS;

    public ShoppingCartDTO(String shoppingCartNumber, List<CartLineDTO> cartLineDTOS) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.cartLineDTOS = cartLineDTOS;
    }
}

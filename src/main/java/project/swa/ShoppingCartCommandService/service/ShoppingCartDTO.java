package project.swa.ShoppingCartCommandService.service;

import java.util.List;

//@Data
//@NoArgsConstructor
public class ShoppingCartDTO {
    private String shoppingCartNumber;
    private List<CartLineDTO> cartLineDTOS;

    public ShoppingCartDTO(String shoppingCartNumber, List<CartLineDTO> cartLineDTOS) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.cartLineDTOS = cartLineDTOS;
    }

    public ShoppingCartDTO() {
    }

    public String getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public void setShoppingCartNumber(String shoppingCartNumber) {
        this.shoppingCartNumber = shoppingCartNumber;
    }

    public List<CartLineDTO> getCartLineDTOS() {
        return cartLineDTOS;
    }

    public void setCartLineDTOS(List<CartLineDTO> cartLineDTOS) {
        this.cartLineDTOS = cartLineDTOS;
    }
}

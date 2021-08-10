package project.swa.ShoppingCartCommandService.service;

import project.swa.ShoppingCartCommandService.domain.CartLine;

public class CartLineAdapter {
    public static CartLine getShoppingCart(CartLineDTO cartLineDTO) {
        return new CartLine(
                cartLineDTO.getQuantity(),
                cartLineDTO.getProduct());
    }

    public static CartLineDTO getShoppingCartDTO(CartLine cartLine) {
        return new CartLineDTO(cartLine.getQuantity(),
                cartLine.getProduct());
    }
}

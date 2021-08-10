package project.swa.ShoppingCartCommandService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "SHOPPINGCART")
public class ShoppingCart {
    @Id
    private String shoppingCartNumber;
    private List<CartLine> cartLines;

    public ShoppingCart(String shoppingCartNumber, List<CartLine> cartLines) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.cartLines = cartLines;
    }
}

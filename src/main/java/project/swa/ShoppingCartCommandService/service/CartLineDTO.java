package project.swa.ShoppingCartCommandService.service;

//@Data
//@NoArgsConstructor
public class CartLineDTO {
    private int quantity;
    private ProductDTO product;

    public CartLineDTO(int quantity, ProductDTO product) {
        this.quantity = quantity;
        this.product = product;
    }

    public CartLineDTO() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}

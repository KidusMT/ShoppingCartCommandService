package project.swa.ShoppingCartCommandService.service;

//@Data
//@NoArgsConstructor
public class StockDTO {
    private int numberInStock;
    private String locationCode;

    public StockDTO(int numberInStock, String locationCode) {
        this.numberInStock = numberInStock;
        this.locationCode = locationCode;
    }

    public StockDTO() {
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}

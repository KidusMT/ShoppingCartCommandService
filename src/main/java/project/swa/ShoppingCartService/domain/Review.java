package project.swa.ShoppingCartService.domain;

import lombok.Data;

@Data
public class Review {
    private String title;
    private String description;
    private double score;

    public Review(String title, String description, double score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }
}

package project.swa.ShoppingCartCommandService.service;

//@Data
//@NoArgsConstructor
public class ReviewDTO {
    private String title;
    private String description;
    private double score;

    public ReviewDTO(String title, String description, double score) {
        this.title = title;
        this.description = description;
        this.score = score;
    }

    public ReviewDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

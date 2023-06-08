package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @Lob
    @Column(name = "GAME_NAME")
    private String gameName;

    @Lob
    @Column(name = "BACKGROUND_IMAGE")
    private String backgroundImage;

    @Column(name = "RATING")
    private String rating;

    @Lob
    @Column(name = "DESCRIPTION_RAW")
    private String descriptionRaw;

    @Column(name = "SUGGESTION_COUNT")
    private String suggestionCount;

    @Column(name = "REVIEW_COUNT")
    private String reviewCount;

    public Game() {
    }

    public Game(Long id, String gameName, String backgroundImage, String rating, String descriptionRaw, String suggestionCount, String reviewCount) {
        this.id = id;
        this.gameName = gameName;
        this.backgroundImage = backgroundImage;
        this.rating = rating;
        this.descriptionRaw = descriptionRaw;
        this.suggestionCount = suggestionCount;
        this.reviewCount = reviewCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescriptionRaw() {
        return descriptionRaw;
    }

    public void setDescriptionRaw(String descriptionRaw) {
        this.descriptionRaw = descriptionRaw;
    }

    public String getSuggestionCount() {
        return suggestionCount;
    }

    public void setSuggestionCount(String suggestionCount) {
        this.suggestionCount = suggestionCount;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

}
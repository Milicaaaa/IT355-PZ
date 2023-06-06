package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_genres")
public class HasGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HAS_GENRES_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GENRE_ID", nullable = false)
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
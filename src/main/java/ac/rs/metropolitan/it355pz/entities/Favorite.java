package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAVORITES_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    public Favorite(Optional<User> user, Optional<Game> game) {
        this.user = user.orElseThrow();
        this.game = game.orElseThrow();
    }

    public Favorite() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
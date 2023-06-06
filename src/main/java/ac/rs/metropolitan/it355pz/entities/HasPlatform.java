package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_platforms")
public class HasPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HAS_PLATFORMS_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PLATFORM_ID", nullable = false)
    private Platform platform;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
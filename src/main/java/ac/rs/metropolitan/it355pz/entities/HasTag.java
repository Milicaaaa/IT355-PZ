package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "has_tag")
public class HasTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HAS_TAG_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;

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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
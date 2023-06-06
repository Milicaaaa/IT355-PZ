package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "is_bought")
public class IsBought {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IS_BOUGHT_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "STORE_ID", nullable = false)
    private Store store;

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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
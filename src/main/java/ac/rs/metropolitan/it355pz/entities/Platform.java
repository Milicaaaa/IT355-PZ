package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "platform")
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLATFORM_ID", nullable = false)
    private Long id;

    @Column(name = "PLATFORM_NAME", length = 500)
    private String platformName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

}
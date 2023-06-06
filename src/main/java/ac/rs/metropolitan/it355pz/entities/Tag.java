package ac.rs.metropolitan.it355pz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID", nullable = false)
    private Long id;

    @Column(name = "TAG_NAME", length = 1024)
    private String tagName;

    @Column(name = "TAG_LANGUAGE", length = 1024)
    private String tagLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagLanguage() {
        return tagLanguage;
    }

    public void setTagLanguage(String tagLanguage) {
        this.tagLanguage = tagLanguage;
    }

}
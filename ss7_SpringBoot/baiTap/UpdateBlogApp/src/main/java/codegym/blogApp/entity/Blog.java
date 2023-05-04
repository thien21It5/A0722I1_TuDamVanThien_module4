package codegym.blogApp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "longtext")
    private String content;
    private String author;
    @Column(columnDefinition = "datetime")
    private LocalDateTime publicDate;
    @Column(columnDefinition = "datetime")
    private LocalDateTime modifiedDate;

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    public Blog() {
    }

    public Blog(Integer id, String title, String content, String author, LocalDateTime publicDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publicDate = publicDate;
        this.modifiedDate = modifiedDate;
    }

    public Blog(Integer id, String title, String content, String author, LocalDateTime publicDate, LocalDateTime modifiedDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publicDate = publicDate;
        this.modifiedDate = modifiedDate;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(LocalDateTime publicDate) {
        this.publicDate = publicDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
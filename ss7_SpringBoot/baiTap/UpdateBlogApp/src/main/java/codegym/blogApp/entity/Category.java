package codegym.blogApp.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(Integer categoryId, String name, Set<Blog> blogs) {
        this.id = categoryId;
        this.name = name;
        this.blogs = blogs;
    }

    public Integer getCategoryId() {
        return id;
    }

    public void setCategoryId(Integer categoryId) {
        this.id = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}

package codegym.blogApp.repository;

import codegym.blogApp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingOrderByPublicDate(String title, Pageable pageable);
}

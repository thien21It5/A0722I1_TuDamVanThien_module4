package codegym.blogApp.service;

import codegym.blogApp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog>{
   Page<Blog> findByTitleContainingOrderByPublicDate(String title, Pageable pageable);
}

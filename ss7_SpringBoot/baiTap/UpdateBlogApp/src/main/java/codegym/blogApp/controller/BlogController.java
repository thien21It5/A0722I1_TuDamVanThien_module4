package codegym.blogApp.controller;

import codegym.blogApp.entity.Blog;
import codegym.blogApp.entity.Category;
import codegym.blogApp.repository.ICategoryRepo;
import codegym.blogApp.service.IBlogService;
import codegym.blogApp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String list(Model model,
                       @RequestParam("searchTitle") Optional<String> searchTitle,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size,
                       @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("publicDate");
        Sort sortBy = Sort.by(sortField).ascending().and(Sort.by("modifiedDate")).ascending();
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sortBy);
        List<Category> categoryList = categoryService.findAll();
        Page<Blog> blogList;
        if (searchTitle.isPresent()) {
            blogList = blogService.findByTitleContainingOrderByPublicDate(searchTitle.get(), pageable);
        } else {
            blogList = blogService.findAll(pageable);
        }

        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryList", categoryList);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setPublicDate(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog has created.");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setModifiedDate(LocalDateTime.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "A blog has updated.");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "delete";
    }

    @PostMapping("/remove")
    public String remove(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Certain blog has removed.");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }
}

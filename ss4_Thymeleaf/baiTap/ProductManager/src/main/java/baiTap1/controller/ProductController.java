package baiTap1.controller;

import baiTap1.entity.Product;
import baiTap1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public String index(Model model) {
        List<Product> productList = productService.show();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "view";
    }

    @GetMapping("/searchName")
    public ModelAndView searchByName(@RequestParam("searching") String nameSearching) {
        ModelAndView modelAndView = new ModelAndView("index", "products", productService.search(nameSearching));
        return modelAndView;
    }
}

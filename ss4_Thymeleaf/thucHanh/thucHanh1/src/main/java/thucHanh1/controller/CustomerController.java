package thucHanh1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thucHanh1.model.Customer;
import thucHanh1.service.CustomerServiceImpl;
import thucHanh1.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.show();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.addCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.showCustomerById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.editCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.showCustomerById(id));
        return "delete";
    }

    @PostMapping("delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.deleteCustomer(customer);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.showCustomerById(id));
        return "view";
    }
}

package thucHanh1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thucHanh1.entity.Customer;
import thucHanh1.service.CustomerServiceImpl;

@Controller
@RequestMapping("/customer")
public class customerController {

    private CustomerServiceImpl customerService;

    // constructor injection
    @Autowired
    public customerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/list"
//            , consumes = {MediaType.APPLICATION_JSON_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE}
//            , headers = {"Content-Type=application/json"}
    )
    public String displayList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }

    @RequestMapping(value = {"/list2", "/"}, method = RequestMethod.GET)
    public String displayList2(ModelMap model) {
        model.addAttribute("students", customerService.findAll());
        return "list";
    }

    @GetMapping("/detail/{id}/{name}")
    public String detail(@PathVariable(name = "id") String id,
                         @PathVariable(name = "name") String name,
                         Model model) {
        model.addAttribute("student", customerService.findById(id));
        return "detail";
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("id") String id) {
//        ModelAndView model = new ModelAndView("student/detail");
        ModelAndView model = new ModelAndView();
        model.setViewName("detail");
        model.addObject("student", customerService.findById(id));
        return model;
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Customer customer = new Customer();
        String[] address = new String[]{"Đà Nẵng", "Huế", "Quảng Nam"};
        model.addAttribute("student", customer);
        model.addAttribute("addresses", address);
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "student") Customer customer, Model model, RedirectAttributes rd) {
        customerService.create(customer);
        rd.addFlashAttribute("message", "Thêm mới student thành công");
        return "redirect:/customer/list";
    }
}

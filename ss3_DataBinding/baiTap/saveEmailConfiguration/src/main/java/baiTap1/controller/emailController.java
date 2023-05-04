package baiTap1.controller;

import baiTap1.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/email")
public class emailController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("email", new Email());

        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        model.addAttribute("listLanguages", languages);

        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(20);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
        model.addAttribute("listPageSize", pageSize);

        return "EmailForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String StorageEmail(@ModelAttribute("email") Email email, Model model) {
        if(email.getSpamFilter() == "true"){
            model.addAttribute("message1", "Enable spams filter");
        }else{
            model.addAttribute("message1", "Spams filter");

        }
        model.addAttribute("email", email);
        model.addAttribute("message","Save successful!!!");
        return "/Email";
    }
}


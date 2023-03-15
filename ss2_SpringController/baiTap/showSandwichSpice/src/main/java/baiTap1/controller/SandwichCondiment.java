package baiTap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichCondiment {

    @GetMapping(value = "/home")
    public String home() {
        return "condiment";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam("condiment") String[] condiments, Model model) {
        String result = "";
        for (String comdiment: condiments) {
            result += comdiment +" ";
        }

        model.addAttribute("result", result);
        return "save";
    }
}

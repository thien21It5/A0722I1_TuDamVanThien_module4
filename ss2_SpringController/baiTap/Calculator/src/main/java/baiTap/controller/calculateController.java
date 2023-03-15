package baiTap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculateController {

    @GetMapping(value = "/home")
    public String home() {
        return "calculator";
    }

    public static int addition(int s1, int s2) {
        return (s1 + s2);
    }

    public int subtraction(int s1, int s2) {
        return s1 - s2;
    }

    public int multiplication(int s1, int s2) {
        return s1 * s2;
    }

    public int division(int s1, int s2) {
        return s1 / s2;
    }

    @PostMapping(value = "/calculate")
    public String Calculator(@RequestParam("s1") String value1, @RequestParam("s2") String value2, @RequestParam("operand") String operand, Model model) {
        if (value1 != null && value2 != null) {
            switch (operand) {
                case "Addition(+)":
                    model.addAttribute("result", addition(Integer.parseInt(value1), Integer.parseInt(value2)));
                    break;
                case "Subtraction(-)":
                    model.addAttribute("result", subtraction(Integer.parseInt(value1), Integer.parseInt(value2)));
                    break;
                case "Multiplication(X)":
                    model.addAttribute("result", multiplication(Integer.parseInt(value1), Integer.parseInt(value2)));
                    break;
                case "Division(/)":
                    model.addAttribute("result", division(Integer.parseInt(value1), Integer.parseInt(value2)));
                    break;
            }
        }
        return "calculator";
    }
}

package codegym.controller;

import codegym.bean.Calculator;
import codegym.service.calculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class tranferMoneyController {
    @Autowired
    private calculatorService calculatorService;

    @GetMapping("/direct")
    public String direct() {
        return "calculate";
    }

    @GetMapping("/calculate")
    public String displayResult(@RequestParam(value = "usd") double usd, @RequestParam(value = "rate") double rate, Model model) {
        double result = calculatorService.tranfer(usd, rate);
        model.addAttribute("calculator", result);
        return "calculate";
    }
}

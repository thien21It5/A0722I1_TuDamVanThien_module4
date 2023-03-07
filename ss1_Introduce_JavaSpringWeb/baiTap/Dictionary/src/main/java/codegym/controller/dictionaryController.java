package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class dictionaryController {

    private String[] vnese = {"Trái chuối", "Quả đào", "Trái nho", "Trái dứa"};
    private String[] engl = {"Banana", "Peach", "Grape", "Pineapple"};

    @GetMapping("/direct")
    public String direct() {
        return "dictionary";
    }

    @GetMapping("/dictionary")
    public String translate(@RequestParam(value = "word") String word, Model model){
        String result = null;

        for (int i =0; i<vnese.length;i++){
            if(word.equals(vnese[i])){
                result = engl[i];
            }
        }

        for (int i =0; i<engl.length;i++){
            if(word.equals(engl[i])){
                result = vnese[i];
            }
        }

        model.addAttribute("word", word);
        model.addAttribute("dictionary", result);

        return "/dictionary";
    }

}

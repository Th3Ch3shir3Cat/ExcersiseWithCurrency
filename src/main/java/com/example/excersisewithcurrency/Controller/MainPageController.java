package com.example.excersisewithcurrency.Controller;

import com.example.excersisewithcurrency.Entity.Valute;
import com.example.excersisewithcurrency.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String mainPage(Model model){
        List<Valute> valutes = mainService.getFiveCurrency();
        model.addAttribute("valutes", valutes);
        return "index";
    }
}

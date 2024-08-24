package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.SinCardService;


@Controller
public class IndexController {

    @Autowired
    private SinCardService sinCardService;
    
    @GetMapping("/")
    public String index(Model model){
        int totalprice = sinCardService.getTotalPrice();
        model.addAttribute("totalprice", totalprice);
        return "index";
    }

    @GetMapping("/addSincardData")
    public String addSincardData(){
        return "addSincardData";
    }

    @GetMapping("/categoryList")
    public String categoryList(){
        return "categoryList";
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        return "addCategory";
    }
    
}

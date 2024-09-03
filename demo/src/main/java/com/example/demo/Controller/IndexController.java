package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Domain.Category;
import com.example.demo.Domain.SinCard;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.SinCardService;


@Controller
public class IndexController {

    @Autowired
    private SinCardService sinCardService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/")
    public String index(Model model){
        int totalprice = sinCardService.getTotalPrice();
        List<String> monthlist = sinCardService.getMonthList();
        model.addAttribute("monthlist", monthlist);
        model.addAttribute("totalprice", totalprice);
        return "index";
    }

    @GetMapping("/addSincardData")
    public String addSincardData(Model model){
        List<Category> categoryList = categoryService.getList(null);
        List<Category> subCategoryList = categoryService.getSubList(null);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("subCategoryList", subCategoryList);
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

    @GetMapping("/subcategoryList")
    public String subcategoryList(){
        return "subcategoryList";
    }
    
    @GetMapping("/addSubCategory")
    public String addSubCategory(){
        return "addSubCategory";
    }

    @GetMapping("/updateSincardData")
    public String updateSincardData(Model model, @RequestParam String idx) throws Exception{
        try {
            int index = Integer.parseInt(idx);
            SinCard sinCard = sinCardService.getOneSinCard(index);
            model.addAttribute("sinCard", sinCard);
            List<Category> categoryList = categoryService.getList(null);
            List<Category> subCategoryList = categoryService.getSubList(null);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("subCategoryList", subCategoryList);
        } catch (Exception e) {
            
            return "redirect:/";
        }
        return "updateSincardData";
    }
}

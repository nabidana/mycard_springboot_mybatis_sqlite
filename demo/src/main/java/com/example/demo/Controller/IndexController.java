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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class IndexController {

    @Autowired
    private SinCardService sinCardService;
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if( session != null ){
            String userid = (String) session.getAttribute("userid");
            if(userid.equals("크림") || userid.equals("파이")){
                return "redirect:/index";
            }
        };
        // int totalprice = sinCardService.getTotalPrice();
        // List<String> monthlist = sinCardService.getMonthList();
        // model.addAttribute("monthlist", monthlist);
        // model.addAttribute("totalprice", totalprice);
        return "home";
    }

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request, @RequestParam(defaultValue = "", required = false) String userid){
        System.out.println("userid : " + userid);
        if("크림".equals(userid) || "파이".equals(userid)){
            HttpSession session = request.getSession();
            session.setAttribute("userid", userid);
            return "redirect:/index";
        }else{
            HttpSession session = request.getSession(false);
            if(session == null ){
                return "redirect:/";
            }
            userid = (String) session.getAttribute("userid");
        }
        List<String> monthlist = sinCardService.getMonthList();
        int totalprice = sinCardService.getTotalPrice(userid);
        int resetday = sinCardService.getResetDay(userid);
        model.addAttribute("monthlist", monthlist);
        model.addAttribute("totalprice", totalprice);
        model.addAttribute("resetday", resetday);
        return "index";
    }

    @GetMapping("/addSincardData")
    public String addSincardData(Model model, HttpServletRequest request){
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
    public String updateSincardData(Model model, @RequestParam String idx, HttpServletRequest request) throws Exception{
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

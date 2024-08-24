package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Category;
import com.example.demo.Domain.CommonSearch;
import com.example.demo.Domain.SinCard;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.SinCardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexRestController {

    @Autowired
    private SinCardService sinCardService;

    @Autowired
    private CategoryService categoryService;
    
    @PostMapping("/getSincardList")
    public ResponseEntity<?> GetSincardList( CommonSearch commonSearch){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        List<SinCard> rsList = sinCardService.getSincardList(commonSearch);
        log.info("rslist : {}", rsList);
        return new ResponseEntity<>(rsList, headers, HttpStatus.OK);
    }

    @PostMapping("/addSinCard")
    public ResponseEntity<?> AddSinCard(SinCard sinCard){
        try {
            log.info("SIN : {}", sinCard);
            sinCardService.addSinCard(sinCard);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/getCategoryList")
    public ResponseEntity<?> getCategoryList( CommonSearch commonSearch){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            List<Category> rsList = categoryService.getList(commonSearch);
            return new ResponseEntity<>(rsList, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        try {
            log.info("category : {}", category);
            categoryService.addCategory(category);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }
    
}

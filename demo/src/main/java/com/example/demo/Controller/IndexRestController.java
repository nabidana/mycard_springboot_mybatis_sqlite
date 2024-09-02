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
    public ResponseEntity<?> AddSinCard( @RequestBody SinCard sinCard){
        try {
            log.info("SIN : {}", sinCard.toString());
            int resultNum = sinCardService.addSinCard(sinCard);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
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
            log.info("category : {}", category.toString());
            int resultNum = categoryService.addCategory(category);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/getSubCategoryList")
    public ResponseEntity<?> getSubCategoryList( CommonSearch commonSearch){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            List<Category> rsList = categoryService.getSubList(commonSearch);
            return new ResponseEntity<>(rsList, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }
    
    @PostMapping("/addSubCategory")
    public ResponseEntity<?> addSubCategory(@RequestBody Category category) {
        try {
            log.info("category : {}", category.toString());
            int resultNum = categoryService.addSubCategory(category);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            log.error("err", e);
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/delCategory")
    public ResponseEntity<?> delCategory(@RequestBody Category category){
        try {
            log.info("category : {}", category.toString());
            int resultNum = categoryService.delCategory(category);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            log.error("err", e);
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/delSubCategory")
    public ResponseEntity<?> delSubCategory(@RequestBody Category category){
        try {
            log.info("category : {}", category.toString());
            int resultNum = categoryService.delSubCategory(category);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            log.error("err", e);
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }

    @PostMapping("/delSincard")
    public ResponseEntity<?> delSincard(@RequestBody SinCard sinCard){
        try {
            log.info("sinCard : {}", sinCard.toString());
            int resultNum = sinCardService.delsincard(sinCard);
            if(resultNum == 0){
                return new ResponseEntity<>("NO", HttpStatus.OK);
            }
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            log.error("err", e);
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }
}

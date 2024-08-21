package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.CommonSearch;
import com.example.demo.Domain.SinCard;
import com.example.demo.Service.SinCardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class IndexRestController {

    @Autowired
    private SinCardService sinCardService;
    
    @PostMapping("/getSincardList")
    public ResponseEntity<?> GetSincardList(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        List<SinCard> rsList = sinCardService.getSincardList(new CommonSearch());
        log.info("rslist : {}", rsList);
        return new ResponseEntity<>(rsList, headers, HttpStatus.OK);
    }

    @PostMapping("/addSinCard")
    public ResponseEntity<?> AddSinCard(
        @RequestBody SinCard sinCard
    ){
        try {
            log.info("SIN : {}", sinCard);
            sinCardService.addSinCard(sinCard);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NO", HttpStatus.OK);
        }
    }
}

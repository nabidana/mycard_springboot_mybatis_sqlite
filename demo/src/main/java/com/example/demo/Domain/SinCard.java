package com.example.demo.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SinCard extends CommonDomain{
    //private int idx;
    //private String title;
    private int price;
    private String inday;
    //private String contents;
    private String category;
    private String subcategory;
    private String card_stat;
}

package com.example.demo.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonSearch extends CommonDomain{
    //private int idx;
    //private String title;
    private int price;
    private String startday;
    private String endday;
}

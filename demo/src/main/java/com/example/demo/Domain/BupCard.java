package com.example.demo.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BupCard extends CommonDomain{
    private int price;
    private String inday;
    private String category;
}

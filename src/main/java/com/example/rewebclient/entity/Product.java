package com.example.rewebclient.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;
}

package com.sachinlakshitha.springbootjpamanytomany.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrdersDto {
    private String id;
    private String number;
    private Double amount;
    private Date createdTime;
    private List<ProductDto> products = new ArrayList<>();
}

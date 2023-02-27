package com.sachinlakshitha.springbootjpamanytomany.service;

import com.sachinlakshitha.springbootjpamanytomany.dto.OrdersDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrdersService {
    Boolean save(OrdersDto ordersDto);
    List<OrdersDto> findAll();
    List<OrdersDto> findAllByPage(Pageable page);
    List<OrdersDto> findAllBySort(Sort sort);
    List<OrdersDto> findAllBySortAndPage(Pageable page);
    OrdersDto findById(String id);
    Boolean update(OrdersDto customerDto);
    void delete(String id);
}

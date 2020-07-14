package com.mapper;

import com.entity.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> selectAll();
}

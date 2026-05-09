package com.pathology.Pathology.service;

import com.pathology.Pathology.dto.CreateOrderRequest;
import com.pathology.Pathology.dto.OrderItemResponse;
import com.pathology.Pathology.entity.TestOrder;

import java.util.List;

public interface TestOrderService {

    String createOrder(CreateOrderRequest request);

    List<TestOrder> getTodayOrders();

    List<OrderItemResponse> getOrderItems(Long orderId);
}

package com.pathology.Pathology.controller;

import com.pathology.Pathology.dto.CreateOrderRequest;
import com.pathology.Pathology.entity.TestOrder;
import com.pathology.Pathology.service.TestOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class TestOrderController {

    private final TestOrderService testOrderService;

    @PostMapping
    public String createOrder(
            @RequestBody CreateOrderRequest request) {
        return testOrderService.createOrder(request);

    }

    @GetMapping("/today")
    public List<TestOrder> getTodayOrders() {
        return testOrderService.getTodayOrders();
    }

    @GetMapping("/{orderId}/items")
    public List<com.pathology.Pathology.dto.OrderItemResponse> getOrderItems(@PathVariable Long orderId) {
        return testOrderService.getOrderItems(orderId);
    }
}

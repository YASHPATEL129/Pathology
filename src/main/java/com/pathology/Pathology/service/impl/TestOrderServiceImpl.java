package com.pathology.Pathology.service.impl;

import com.pathology.Pathology.dto.CreateOrderRequest;
import com.pathology.Pathology.dto.OrderItemResponse;
import com.pathology.Pathology.entity.PathologyTest;
import com.pathology.Pathology.entity.TestOrder;
import com.pathology.Pathology.entity.TestOrderItem;
import com.pathology.Pathology.repository.PathologyTestRepository;
import com.pathology.Pathology.repository.TestOrderItemRepository;
import com.pathology.Pathology.repository.TestOrderRepository;
import com.pathology.Pathology.service.TestOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestOrderServiceImpl implements TestOrderService {

    private final TestOrderRepository testOrderRepository;

    private final TestOrderItemRepository testOrderItemRepository;

    private final PathologyTestRepository pathologyTestRepository;


    @Override
    public String createOrder(CreateOrderRequest request) {
        // CREATE ORDER
        TestOrder testOrder = new TestOrder();
        testOrder.setPatientName(
                request.getPatientName());
        testOrder.setPhone(
                request.getPhone());
        testOrder.setOrderDate(
                LocalDateTime.now());

        // UNIQUE ORDER NUMBE
        String orderNumber =
                "LAB" + System.currentTimeMillis();
        testOrder.setOrderNumber(orderNumber);

        // SAVE ORDER
        TestOrder savedOrder =
                testOrderRepository.save(testOrder);

        // SAVE ORDER ITEMS

        for (Long testId : request.getTestIds()) {

            TestOrderItem item =
                    new TestOrderItem();

            item.setOrderId(savedOrder.getId());

            item.setTestId(testId);

            testOrderItemRepository.save(item);

        }
        return "Order Created Successfully";
    }

    @Override
    public List<TestOrder> getTodayOrders() {
        LocalDateTime startDate =
                LocalDate.now().atStartOfDay();

        LocalDateTime endDate =
                LocalDate.now().atTime(23, 59, 59);

        return testOrderRepository
                .getTodayOrders(startDate, endDate);
    }

    @Override
    public List<OrderItemResponse> getOrderItems(Long orderId) {
        List<TestOrderItem> items = testOrderItemRepository.findByOrderId(orderId);
        
        return items.stream().map(item -> {
            PathologyTest test = pathologyTestRepository.findById(item.getTestId()).orElse(null);
            OrderItemResponse resp = new OrderItemResponse();
            resp.setId(item.getId());
            resp.setOrderId(item.getOrderId());
            resp.setTestId(item.getTestId());
            resp.setResultValue(item.getResultValue());
            resp.setTechnicianNotes(item.getTechnicianNotes());
            resp.setCompleted(item.getCompleted());
            
            if (test != null) {
                resp.setTestName(test.getTestName());
                resp.setSampleType(test.getSampleType());
                resp.setNormalRange(test.getNormalRange());
            }
            
            return resp;
        }).toList();
    }
}

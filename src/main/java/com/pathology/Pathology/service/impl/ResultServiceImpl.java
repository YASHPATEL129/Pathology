package com.pathology.Pathology.service.impl;

import com.pathology.Pathology.dto.ResultEntryRequest;
import com.pathology.Pathology.entity.TestOrderItem;
import com.pathology.Pathology.repository.TestOrderItemRepository;
import com.pathology.Pathology.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final TestOrderItemRepository testOrderItemRepository;


    @Override
    public String enterResult(Long orderItemId, ResultEntryRequest request) {
        TestOrderItem item =
                testOrderItemRepository
                        .findById(orderItemId)
                        .orElseThrow();
        item.setResultValue(
                request.getResultValue());
        item.setTechnicianNotes(
                request.getTechnicianNotes());
        item.setCompleted(true);
        testOrderItemRepository.save(item);
        return "Result Saved Successfully";
    }

    @Override
    public List<TestOrderItem> getCompletedResults(Long orderId) {
        return testOrderItemRepository
                .findByOrderIdAndCompletedTrue(orderId);
    }
}

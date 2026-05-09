package com.pathology.Pathology.service;

import com.pathology.Pathology.dto.ResultEntryRequest;
import com.pathology.Pathology.entity.TestOrderItem;

import java.util.List;

public interface ResultService {

    String enterResult(
            Long orderItemId,
            ResultEntryRequest request);

    List<TestOrderItem> getCompletedResults(Long orderId);
}

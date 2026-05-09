package com.pathology.Pathology.controller;


import com.pathology.Pathology.dto.ResultEntryRequest;
import com.pathology.Pathology.entity.TestOrderItem;
import com.pathology.Pathology.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    // ENTER RESULT

    @PostMapping("/{orderItemId}")
    public String enterResult(
            @PathVariable Long orderItemId,
            @RequestBody ResultEntryRequest request) {
        return resultService
                .enterResult(orderItemId, request);

    }

    // VIEW COMPLETED RESULTS

    @GetMapping("/order/{orderId}")
    public List<TestOrderItem>
        getCompletedResults(
            @PathVariable Long orderId) {
        return resultService
                .getCompletedResults(orderId);
    }
}

package com.pathology.Pathology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
    private Long id;
    private Long orderId;
    private Long testId;
    private String testName;
    private String sampleType;
    private String normalRange;
    private String resultValue;
    private String technicianNotes;
    private Boolean completed;
}

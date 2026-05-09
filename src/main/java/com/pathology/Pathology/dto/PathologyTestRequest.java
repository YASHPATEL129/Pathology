package com.pathology.Pathology.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PathologyTestRequest {

    private String testName;

    private String testCode;

    private String sampleType;

    private String normalRange;

    private BigDecimal price;
}

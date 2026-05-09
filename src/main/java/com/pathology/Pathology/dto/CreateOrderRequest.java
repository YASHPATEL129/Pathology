package com.pathology.Pathology.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    private String patientName;

    private String phone;

    private List<Long> testIds;
}

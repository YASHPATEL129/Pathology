package com.pathology.Pathology.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "test_order_item")
@Data
public class TestOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Long testId;

    private String resultValue;

    private String technicianNotes;

    private Boolean completed = false;
}

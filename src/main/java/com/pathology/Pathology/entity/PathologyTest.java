package com.pathology.Pathology.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pathology_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PathologyTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String testName;

    private String testCode;

    private String sampleType;

    private String normalRange;

    private BigDecimal price;

    private Boolean active = true;

}

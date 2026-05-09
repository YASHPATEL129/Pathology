package com.pathology.Pathology.service;

import com.pathology.Pathology.dto.PathologyTestRequest;
import com.pathology.Pathology.entity.PathologyTest;

import java.util.List;

public interface PathologyTestService {

    String createTest(PathologyTestRequest request);

    List<PathologyTest> getTests(String search);

    List<PathologyTest> getActiveTests();
}

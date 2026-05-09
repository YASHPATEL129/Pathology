package com.pathology.Pathology.service.impl;

import com.pathology.Pathology.dto.PathologyTestRequest;
import com.pathology.Pathology.entity.PathologyTest;
import com.pathology.Pathology.repository.PathologyTestRepository;
import com.pathology.Pathology.service.PathologyTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PathologyTestServiceImpl implements PathologyTestService {

    private final PathologyTestRepository pathologyTestRepository;


    @Override
    public String createTest(
            PathologyTestRequest request) {

        PathologyTest pathologyTest =
                new PathologyTest();

        pathologyTest.setTestName(
                request.getTestName());

        pathologyTest.setTestCode(
                request.getTestCode());

        pathologyTest.setSampleType(
                request.getSampleType());

        pathologyTest.setNormalRange(
                request.getNormalRange());

        pathologyTest.setPrice(
                request.getPrice());

        pathologyTest.setActive(true);

        pathologyTestRepository.save(pathologyTest);

        return "Test Created Successfully";
    }

    public List<PathologyTest> getTests(String name) {
        return pathologyTestRepository.getTests(name);
    }

    @Override
    public List<PathologyTest> getActiveTests() {
        return pathologyTestRepository.getActiveTests();
    }
}

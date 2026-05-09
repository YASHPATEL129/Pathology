package com.pathology.Pathology.controller;


import com.pathology.Pathology.dto.PathologyTestRequest;
import com.pathology.Pathology.entity.PathologyTest;
import com.pathology.Pathology.service.PathologyTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class PathologyTestController {

    private final PathologyTestService pathologyTestService;

    @PostMapping
    public String createTest(
            @RequestBody
            PathologyTestRequest request) {
        return pathologyTestService.createTest(request);
    }

    @GetMapping
    public List<PathologyTest> getTests(
            @RequestParam(required = false) String name) {
        return pathologyTestService.getTests(name);
    }

    @GetMapping("/active")
    public List<PathologyTest> getActiveTests() {
        return pathologyTestService.getActiveTests();
    }

}

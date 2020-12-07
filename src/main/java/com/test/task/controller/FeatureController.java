package com.test.task.controller;

import com.test.task.dto.FeatureDto;
import com.test.task.dto.FeatureDtoWrapper;
import com.test.task.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static java.util.Collections.singletonList;

@Slf4j
@RestController
@RequestMapping("/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping
    public FeatureDtoWrapper getAllFeatures() {
        log.info("Performing getAllFeatures call.");
        return FeatureDtoWrapper.builder()
                .features(featureService.getAllFeatures())
                .build();
    }

    @GetMapping("/{featureId}")
    public FeatureDtoWrapper getFeatureById(@PathVariable(value = "featureId") final Long featureId) {
        log.info("Performing getFeatureById({}) call.", featureId);
        final FeatureDto feature = featureService.getFeatureById(featureId);
        return FeatureDtoWrapper.builder()
                .features(singletonList(feature))
                .build();
    }

    @DeleteMapping("/{featureId}")
    public void deleteFeatureById(@PathVariable(value = "featureId") final Long featureId) {
        log.info("Performing deleteFeatureById({}) call.", featureId);
        featureService.deleteFeatureById(featureId);
    }

}


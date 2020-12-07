package com.test.task.service;

import com.test.task.dto.FeatureDto;

import java.util.List;

public interface FeatureService {

    List<FeatureDto> getAllFeatures();
    FeatureDto getFeatureById(Long featureId);
    void deleteFeatureById(Long featureId);

}

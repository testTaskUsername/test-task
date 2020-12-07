package com.test.task.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class FeatureDtoWrapper {

    List<FeatureDto> features;
}

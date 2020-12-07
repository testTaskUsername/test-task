package com.test.task.mapper;

import com.test.task.dto.FeatureDto;
import com.test.task.entity.Feature;
import com.test.task.util.TestDataHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FeatureMapperTest {

    @InjectMocks
    private FeatureMapper featureMapper;

    private final List<Feature> features = TestDataHelper.buildFeatureList();
    private final List<FeatureDto> featureDtos = TestDataHelper.buildFeatureDtoList();

    @Test
    public void mapToDtoListSuccess() {
        final List<FeatureDto> result = featureMapper.mapToDto(features);

        assertEquals(result, featureDtos);
    }


    @Test
    public void mapToDtoSuccess() {
        final FeatureDto featureDto = featureMapper.mapToDto(features.get(0));

        assertEquals(featureDto, featureDtos.get(0));
    }

}
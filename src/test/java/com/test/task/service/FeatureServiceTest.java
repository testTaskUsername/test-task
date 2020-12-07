package com.test.task.service;

import com.test.task.dto.FeatureDto;
import com.test.task.entity.Feature;
import com.test.task.exception.FeatureNotFoundException;
import com.test.task.mapper.FeatureMapper;
import com.test.task.repository.FeatureRepository;
import com.test.task.service.impl.FeatureServiceImpl;
import com.test.task.util.TestDataHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FeatureServiceTest {

    @InjectMocks
    private FeatureServiceImpl featureService;

    @Mock
    private FeatureMapper featureMapper;

    @Mock
    private FeatureRepository featureRepository;

    private final Long featureId = 1L;
    private final Long invalidFeatureId = -1L;
    private final List<Feature> featureList = TestDataHelper.buildFeatureList();
    private final List<FeatureDto> featureDtoList = TestDataHelper.buildFeatureDtoList();

    @Test
    public void getAllFeaturesSuccess() {
        when(featureRepository.findAll()).thenReturn(featureList);
        when(featureMapper.mapToDto(featureList)).thenReturn(featureDtoList);

        final List<FeatureDto> result = featureService.getAllFeatures();

        verify(featureRepository).findAll();
        verify(featureMapper).mapToDto(featureList);

        assertEquals(result, featureDtoList);
    }

    @Test
    public void getFeatureByIdSuccess() {
        final Feature feature = featureList.get(0);
        final Optional<Feature> optional = Optional.of(feature);
        final FeatureDto featureDto = featureDtoList.get(0);

        when(featureRepository.findById(featureId)).thenReturn(optional);
        when(featureMapper.mapToDto(feature)).thenReturn(featureDto);

        final FeatureDto result = featureService.getFeatureById(featureId);

        verify(featureRepository).findById(featureId);
        verify(featureMapper).mapToDto(feature);

        assertEquals(result, featureDto);
    }

    @Test(expected = FeatureNotFoundException.class)
    public void getFeatureByIdFailsWithInvalidId() {
        when(featureRepository.findById(invalidFeatureId)).thenThrow(FeatureNotFoundException.class);
        featureService.getFeatureById(invalidFeatureId);
        verify(featureRepository).findById(featureId);
    }


    @Test
    public void deleteFeatureByIdSuccess() {
        when(featureRepository.existsById(featureId)).thenReturn(true);

        featureService.deleteFeatureById(featureId);

        verify(featureRepository).existsById(featureId);
        verify(featureRepository).deleteById(featureId);
    }

    @Test(expected = FeatureNotFoundException.class)
    public void deleteFeatureByIdFailsWithInvalidId() {
        when(featureRepository.existsById(invalidFeatureId)).thenReturn(false);

        featureService.deleteFeatureById(invalidFeatureId);

        verify(featureRepository).existsById(featureId);
        verify(featureRepository, never()).deleteById(featureId);
    }
}
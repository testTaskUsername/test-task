package com.test.task.service.impl;

import com.test.task.dto.FeatureDto;
import com.test.task.entity.Feature;
import com.test.task.exception.FeatureNotFoundException;
import com.test.task.mapper.FeatureMapper;
import com.test.task.repository.FeatureRepository;
import com.test.task.service.FeatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    public static final String FEATURE_NOT_FOUND_MESSAGE_FORMAT = "Couldn't find feature with id:%s";

    private final FeatureMapper featureMapper;
    private final FeatureRepository featureRepository;

    @Override
    @Transactional
    public List<FeatureDto> getAllFeatures() {
        final List<Feature> features = featureRepository.findAll();
        return featureMapper.mapToDto(features);
    }

    @Override
    public FeatureDto getFeatureById(final Long featureId) {
        return featureRepository.findById(featureId)
                .map(featureMapper::mapToDto)
                .orElseThrow(() -> {
                    final String message = String.format(FEATURE_NOT_FOUND_MESSAGE_FORMAT, featureId);
                    log.error(message);
                    return new FeatureNotFoundException(message);
                });
    }

    @Override
    @Transactional
    public void deleteFeatureById(final Long featureId) {
        checkExists(featureId);
        featureRepository.deleteById(featureId);
    }

    private void checkExists(final Long featureId) {
        if (!featureRepository.existsById(featureId)) {
            final String message = String.format(FEATURE_NOT_FOUND_MESSAGE_FORMAT, featureId);
            log.error(message);
            throw new FeatureNotFoundException(message);
        }
    }
}

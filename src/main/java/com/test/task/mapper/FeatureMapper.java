package com.test.task.mapper;

import com.test.task.dto.FeatureDto;
import com.test.task.entity.Feature;
import com.test.task.entity.Service;
import com.test.task.entity.WorkHours;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Component
public class FeatureMapper {

    public List<FeatureDto> mapToDto(final List<Feature> features) {
        return emptyIfNull(features).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public FeatureDto mapToDto(final Feature feature) {
        return FeatureDto.builder()
                .id(feature.getId())
                .type(feature.getType())
                .companyId(feature.getCompanyId())
                .nameRu(feature.getNameRu())
                .nameUa(feature.getNameUa())
                .nameEn(feature.getNameEn())
                .isOnline(feature.getIsOnline())
                .isVisible(feature.getIsOnline())
                .workHours(mapHours(feature.getWorkHours()))
                .services(emptyIfNull(feature.getServices()).stream()
                        .collect(Collectors.toMap(Service::getName, Service::getValue)))
                .build();
    }

    private List<List<String>> mapHours(final List<WorkHours> workHours) {
        return emptyIfNull(workHours).stream()
                .map(WorkHours::getHours)
                .map(e -> stream(e.split(","))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
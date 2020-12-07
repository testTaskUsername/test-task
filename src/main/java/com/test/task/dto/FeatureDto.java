package com.test.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
@Builder
public class FeatureDto {

    Long id;
    String type;
    @JsonProperty("company_id")
    Long companyId;
    @JsonProperty("name_ru")
    String nameRu;
    @JsonProperty("name_ua")
    String nameUa;
    @JsonProperty("name_en")
    String nameEn;
    @JsonProperty("is_online")
    Boolean isOnline;
    @JsonProperty("is_visible")
    Boolean isVisible;
    @JsonProperty("work_hours")
    List<List<String>> workHours;
    Map<String, Boolean> services;

}

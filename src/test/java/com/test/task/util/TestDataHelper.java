package com.test.task.util;

import com.test.task.dto.FeatureDto;
import com.test.task.entity.Feature;
import com.test.task.entity.Service;
import com.test.task.entity.WorkHours;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class TestDataHelper {

    public static List<Feature> buildFeatureList() {
        return List.of(
                Feature.builder()
                        .id(218L)
                        .type("city")
                        .companyId(31L)
                        .nameRu("Первое город")
                        .nameUa("Перше міське")
                        .nameEn("First municipal")
                        .isOnline(true)
                        .isVisible(true)
                        .services(buildServices())
                        .workHours(buildWorkHours())
                        .build()
        );
    }

    private static List<WorkHours> buildWorkHours() {
        return List.of(
                WorkHours.builder()
                        .id(1L)
                        .hours("0040,0080")
                        .build(),
                WorkHours.builder()
                        .id(2L).
                        hours("0040,0080")
                        .build());
    }

    private static List<Service> buildServices() {
        return List.of(
                Service.builder()
                        .id(1L)
                        .name("vip")
                        .value(false)
                        .build(),
                Service.builder()
                        .id(2L)
                        .name("all_hours")
                        .value(false)
                        .build(),
                Service.builder()
                        .id(3L)
                        .name("pi")
                        .value(true)
                        .build(),
                Service.builder()
                        .id(4L)
                        .name("entities")
                        .value(true)
                        .build(),
                Service.builder()
                        .id(5L)
                        .name("premium")
                        .value(true)
                        .build(),
                Service.builder()
                        .id(6L)
                        .name("english_speaking")
                        .value(true)
                        .build()
        );
    }

    public static List<FeatureDto> buildFeatureDtoList() {
        return List.of(
                FeatureDto.builder()
                        .id(218L)
                        .type("city")
                        .companyId(31L)
                        .nameRu("Первое город")
                        .nameUa("Перше міське")
                        .nameEn("First municipal")
                        .isOnline(true)
                        .isVisible(true)
                        .services(buildServicesDto())
                        .workHours(buildWorkHoursDto())
                        .build()
        );
    }

    private static List<List<String>> buildWorkHoursDto() {
        return List.of(
                List.of("0040", "0080"),
                List.of("0040", "0080")
        );
    }

    public static Map<String, Boolean> buildServicesDto() {
        return new HashMap<>() {{
            put("vip", false);
            put("all_hours", false);
            put("pi", true);
            put("entities", true);
            put("premium", true);
            put("english_speaking", true);
        }};
    }
}

package com.test.task.repository;

import com.test.task.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository
        extends JpaRepository<Feature, Long> {
}

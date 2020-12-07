package com.test.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "features")
public class Feature {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "name_ru")
    private String nameRu;
    @Column(name = "name_ua")
    private String nameUa;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "is_online")
    private Boolean isOnline;
    @Column(name = "is_visible")
    private Boolean isVisible;

    @OneToMany(
            mappedBy = "feature",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Service> services;

    @OneToMany(
            mappedBy = "feature",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<WorkHours> workHours;

}

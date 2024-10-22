package com.quarkus.smartbackoffice.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @SequenceGenerator(name = "entity_seq", sequenceName = "entity_seq")
    @GeneratedValue(generator = "entity_seq")
    private Long id;

}

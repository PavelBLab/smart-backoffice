package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "backoffice_categories")
public class Category extends BaseEntity {

    private String name;
    private String description;


}

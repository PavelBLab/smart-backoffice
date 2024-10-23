package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BACKOFFICE_CATEGORIES")
public class Category extends BaseEntity{

    private String name;
    private String description;


}

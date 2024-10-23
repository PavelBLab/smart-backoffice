package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "BACKOFFICE_ARTICLES")
public class Article extends BaseEntity{

    private String name;
    private BigDecimal price;
    private String description;
    private String picture;

}

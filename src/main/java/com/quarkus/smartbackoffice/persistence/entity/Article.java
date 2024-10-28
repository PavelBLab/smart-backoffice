package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "backoffice_articles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "category_id"})
})
public class Article extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private String description;

    @NotNull
    private String picture;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

}

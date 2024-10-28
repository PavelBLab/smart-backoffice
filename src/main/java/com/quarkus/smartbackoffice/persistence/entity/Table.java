package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "backoffice_tables", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Table extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private Integer seatCount;

    @NotNull
    private Boolean active;

}

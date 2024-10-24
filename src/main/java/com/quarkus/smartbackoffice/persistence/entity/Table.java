package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "backoffice_tables", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Table extends BaseEntity{

    @NotNull
    private String name;

    @NotNull
    private Integer seatCount;

    @NotNull
    private Boolean active;

}

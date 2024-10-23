package com.quarkus.smartbackoffice.persistence.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "BACKOFFICE_TABLES")
public class Table extends BaseEntity{

    private String name;
    private Integer seatCount;
    private Boolean active;

}

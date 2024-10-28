package com.quarkus.smartbackoffice.persistence.entity;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
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
@UserDefinition // security.jpa
@Table(name = "backoffice_users")
public class User extends BaseEntity {

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

}

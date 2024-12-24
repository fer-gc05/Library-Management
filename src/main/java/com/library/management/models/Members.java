package com.library.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(nullable = false)
    @JsonProperty("first_name")
    private String firstName;

    @Column(nullable = false)
    @JsonProperty("last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;
}

package com.library.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(nullable = false)
    @JsonProperty("loan_date")
    private String loanDate;

    @JsonProperty("return_date")
    private String returnDate;

    @JsonProperty("returned_date")
    private String returnedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    @JsonProperty("book")
    private Books book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    @JsonProperty("member")
    private Members member;
}

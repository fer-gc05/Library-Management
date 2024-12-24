package com.library.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private long id;

    @Column(nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(nullable = false)
    @JsonProperty("publisher")
    private String publisher;

    @Column(nullable = false)
    @JsonProperty("published_date")
    private String publishedDate;

    @Column(nullable = false, length = 3000)
    @JsonProperty("description")
    private String description;

    @Column(nullable = false)
    @JsonProperty("page_count")
    private int pageCount;

    @Column(nullable = false)
    @JsonProperty("categories")
    private String categories;

    @Column(nullable = false)
    @JsonProperty("lenguage")
    private String language;

    @Column(nullable = false)
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    @JsonProperty("author")
    private Authors author;

}

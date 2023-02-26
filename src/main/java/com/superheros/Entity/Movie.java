package com.superheros.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "dateCreation")
    private String dateCreation;

    @NotNull
    @Column(name = "qualification")
    private Integer qualification;

    @NotNull
    @Column(name = "url")
    private String urlImg;

    @JoinTable(name = "characters_movies",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "character_id"))
    @ManyToMany( fetch = FetchType.LAZY,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters;

    @JoinTable(name = "movie_genre",
        joinColumns = {@JoinColumn(name = "movie_id")},
        inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Genre> genres;

    public Movie() {
    }

    public Movie(String title, String dateCreation, Integer qualification, String urlImg, Set<Character> characters, Set<Genre> genres) {
        this.title = title;
        this.dateCreation = dateCreation;
        this.qualification = qualification;
        this.urlImg = urlImg;
        this.characters = characters;
        this.genres = genres;
    }
}

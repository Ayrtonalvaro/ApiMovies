package com.superheros.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "age")
    private Long age;
    @NotNull
    @Column(name = "weight")
    private Long weight;
    @NotNull
    @Column(name = "bibliography")
    private String bibliography;

    @NotNull
    @Column(name = "url")
    private String urlImg;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "characters_movies",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;

    public Character() {
    }

    public Character(String name, Long age, Long weight, String bibliography, String urlImg, Set<Movie> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.bibliography = bibliography;
        this.urlImg = urlImg;
        this.movies = movies;
    }
}

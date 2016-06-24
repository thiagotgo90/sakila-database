package org.tgo.jpa.model.media;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.tgo.jpa.model.location.Language;
import org.tgo.jpa.model.people.Actor;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "film_id", columnDefinition = "SMALLINT(5)")
    private int id;

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_year", columnDefinition = "YEAR")
    @Temporal(TemporalType.DATE)
    private Date releaseYear;

    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;
    
    @ManyToOne
    @JoinColumn(name="original_language_id")
    private Language originalLanguage;
    
    @Column(name="rental_duration", columnDefinition="TINYINT", length = 3)
    private int rentalDuration;
    
    @Column(name="rental_rate", columnDefinition="DECIMAL(4,2)")
    private double rentalRate;
    
    @Column(columnDefinition="SMALLINT(5)")
    private int length;
    
    @Column(name="replcacement_cost", columnDefinition="DECIMAL(5,2)")
    private double replcacementCost;
    
    @Enumerated(EnumType.STRING)
    private Rating rating;
    

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "film_id"), 
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actor;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "film_id"), 
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> category;

}

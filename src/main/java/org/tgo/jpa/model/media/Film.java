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
    
    @Column(name="replacement_cost", columnDefinition="DECIMAL(5,2)")
    private double replacementCost;
    
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum")
    private Rating rating;
    
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "film_id"), 
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "film_id"), 
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }
    
}

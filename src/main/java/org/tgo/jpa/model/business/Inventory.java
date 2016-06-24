package org.tgo.jpa.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.tgo.jpa.model.media.Film;

@Entity
@Table(name="inventory")
public class Inventory {
    
    @Id
    @Column(name="inventory_id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;
    
    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    

}

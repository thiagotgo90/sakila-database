package org.tgo.jpa.model.people;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.tgo.jpa.model.media.Film;

/**
 * @author thiago
 *
 */
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actor_id", columnDefinition = "SMALLINT(5)")
    private int id;

    @Embedded
    private Identification name;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Identification getName() {
        return name;
    }

    public void setName(Identification name) {
        this.name = name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}

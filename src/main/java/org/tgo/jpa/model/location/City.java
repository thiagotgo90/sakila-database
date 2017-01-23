package org.tgo.jpa.model.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

    @Id
    @Column(name = "city_id", columnDefinition = "SMALLINT(5)")
    private int id;

    @Column(name = "city", length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
}

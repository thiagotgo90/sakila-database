package org.tgo.jpa.model.location;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_id", columnDefinition = "SMALLINT(5)")
    private int id;

    @Column(name = "country", length = 50)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<City> citys;

}

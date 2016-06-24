package org.tgo.jpa.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rental")
public class Rental {

    @Id
    @Column(name="rental_id")
    private int id;
    
}

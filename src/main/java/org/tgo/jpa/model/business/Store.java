package org.tgo.jpa.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
    
    @Id
    @Column(name="store_id")
    private int id;

}

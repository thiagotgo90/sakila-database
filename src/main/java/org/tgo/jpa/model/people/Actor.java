package org.tgo.jpa.model.people;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {
    
    @Id
    @Column(name = "actor_id", columnDefinition = "SMALLINT(5)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Embedded
    private Identification name;
    

}

package org.tgo.jpa.model.people;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Identification {
    
    @Column(name = "first_name",length = 55)
    private String first;
    
    @Column(name = "last_name",length = 55)
    private String last;

}

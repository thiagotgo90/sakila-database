package org.tgo.jpa.model.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language {
    
    @Id
    @Column(name="language_id", columnDefinition="TINYINT(3)")
    private int id;
    
    @Column(columnDefinition="CHAR(20)")
    private String name;
    

}

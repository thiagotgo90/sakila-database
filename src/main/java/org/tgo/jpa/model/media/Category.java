package org.tgo.jpa.model.media;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    
    @Id
    @Column(name="category_id", columnDefinition="TINYINT(3)")
    private int id;
    
    @Column(length = 25)
    private String name;
    

}

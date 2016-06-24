package org.tgo.jpa.model.people;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id", columnDefinition = "TINYINT(3)")
    private int id;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="first_name", column=@Column(name="first_name", columnDefinition="VARCHAR(45)")),
        @AttributeOverride(name="last_name", column=@Column(name="last_name", columnDefinition="VARCHAR(45)"))
        })
    private Identification name;
    
    
    
    @Lob
    private byte[] picture;

}

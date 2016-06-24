package org.tgo.jpa.model.people;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="staff_id")),
    })
public class Staff extends People {

    @Lob
    private byte[] picture;

}

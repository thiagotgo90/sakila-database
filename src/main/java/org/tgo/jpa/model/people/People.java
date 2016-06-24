package org.tgo.jpa.model.people;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.tgo.jpa.model.business.Store;
import org.tgo.jpa.model.location.Address;
import org.tgo.jpa.util.people.ClientStatusConverter;

/**
 * @author thiago
 * 
 * This inheritance strategy probability make no sense, 
 * but a did this just to make more complex queries
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class People {

    @Id
    private int id;

    @ManyToOne
    private Store store;

    @Embedded
    private Identification clientIdentification;

    @Column(nullable = true)
    private String email;

    @ManyToOne
    private Address adress;

    @Convert(converter = ClientStatusConverter.class)
    private boolean active;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Identification getClientIdentification() {
        return clientIdentification;
    }

    public void setClientIdentification(Identification clientIdentification) {
        this.clientIdentification = clientIdentification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
    
}

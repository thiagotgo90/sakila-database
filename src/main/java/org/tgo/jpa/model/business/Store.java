package org.tgo.jpa.model.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.tgo.jpa.model.location.Address;
import org.tgo.jpa.model.people.Staff;

@Entity
@Table(name="store")
public class Store {
    
    @Id
    @Column(name="store_id")
    private int id;
    
    @OneToOne
    private Staff manager;
    
    @OneToOne
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }
    
    

}

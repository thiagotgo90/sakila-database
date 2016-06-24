package org.tgo.jpa.model.people;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.tgo.jpa.model.business.Store;
import org.tgo.jpa.model.location.Address;
import org.tgo.jpa.util.people.ClientStatusConverter;

/**
 * @author thiago
 * 
 *         This inheritance strategy probability make no sense, but a did this
 *         just to make more complex queries
 *
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class People {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store homeStore;

    @Embedded
    private Identification clientIdentification;

    @Column(nullable = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Convert(converter = ClientStatusConverter.class)
    @Column(columnDefinition = "BIT", length = 1)
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Store getHomeStore() {
        return homeStore;
    }

    public void setHomeStore(Store homeStore) {
        this.homeStore = homeStore;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

package org.tgo.jpa.model.people;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.tgo.jpa.model.business.Payment;
import org.tgo.jpa.model.business.Rental;
import org.tgo.jpa.model.business.Store;

@Entity
@Table(name = "staff")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "staff_id")), })
public class Staff extends People {

    @Lob
    private byte[] picture;

    private String username;

    private String password;

    @OneToMany(mappedBy = "staff")
    private List<Rental> rents;

    @OneToMany(mappedBy = "staff")
    private List<Payment> payments;

    @OneToOne(mappedBy = "manager")
    private Store managedStore;

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

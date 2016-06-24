package org.tgo.jpa.model.people;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.tgo.jpa.model.business.Payment;
import org.tgo.jpa.model.business.Rental;

@Entity
@Table(name = "customer")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "customer_id", columnDefinition="smallint(5)")), })
public class Customer extends People {

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;
    
    @OneToMany(mappedBy = "customer")
    private List<Rental> rents;
    
    
    public List<Rental> getRents() {
        return rents;
    }

    public void setRents(List<Rental> rents) {
        this.rents = rents;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}

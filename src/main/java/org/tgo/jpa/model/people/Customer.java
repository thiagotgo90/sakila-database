package org.tgo.jpa.model.people;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.tgo.jpa.model.business.Payment;

@Entity
@Table(name = "customer")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "customer_id")), })
public class Customer extends People {

    
    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;
    
    
    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}

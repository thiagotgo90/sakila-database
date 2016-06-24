package org.tgo.jpa.model.business;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.tgo.jpa.model.people.Customer;
import org.tgo.jpa.model.people.Staff;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @Column(name = "rental_id")
    private int id;

    @Column(name = "rental_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rental;
    
    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="return")
    private Date devolution;
    
    @ManyToOne
    private Staff staff;
}

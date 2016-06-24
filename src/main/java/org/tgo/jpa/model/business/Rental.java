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
    @Column(name="return_date")
    private Date devolution;
    
    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRental() {
        return rental;
    }

    public void setRental(Date rental) {
        this.rental = rental;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDevolution() {
        return devolution;
    }

    public void setDevolution(Date devolution) {
        this.devolution = devolution;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
}

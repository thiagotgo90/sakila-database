package org.tgo.jpa.model.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id", columnDefinition = "SMALLINT", length = 5)
    private int id;

    @Column(name = "address", length = 50, nullable = false)
    private String firstAddress;

    @Column(name = "address2", length = 50)
    private String secondAddress;

    @Column(length = 20)
    private String district;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(length = 20)
    private String phone;

}

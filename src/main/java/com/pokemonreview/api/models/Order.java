package com.pokemonreview.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Order_M")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "order_id")
    private Integer order_id;
   // @Column(name = "orderedAt")
    //@CreationTimestamp
    //@UpdateTimestamp
    private LocalDateTime orderedAt;
    /*
    //customer id
    @Column(name = "customer_id")
    private Integer customer_id;
*/
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer_id;
    //@JsonBackReference
    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer Customer;*/

/*
    @JsonBackReference
    @OneToMany(mappedBy = "Order")
    private List<Product_Order> productOrders;*/
    @OneToMany(mappedBy = "order_id")
    private List<Product_Order> orderId ;
}

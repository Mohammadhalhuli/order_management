package com.pokemonreview.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;

@Table(name = "Customer")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "customer_id")
    private Integer customer_id;
    //@Column(name = "firstName")
    private String firstName;
    //@Column(name = "lastName")
    private String lastName;
    //@Column(name = "bornAt")
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    //private Date bornAt;

    //@UpdateTimestamp
    private LocalDate bornAt;
    @OneToMany(mappedBy = "customer_id")
    private List<Order> orders;
/*
    @JsonBackReference
    @OneToMany(mappedBy = "Customer")
    private List<Order> orders;
*/
}

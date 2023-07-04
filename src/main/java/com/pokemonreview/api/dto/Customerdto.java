package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
public class Customerdto {
    private Integer customer_id;
    private String firstName;
    private String lastName;
    @UpdateTimestamp
    private LocalDate bornAt;
    private List<Order> order;

}

package com.pokemonreview.api.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "Stock")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer stock_id;
    //private int productId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    /*
    @Column(name = "prduct_id")
    private Integer prduct_id;*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prduct_id",referencedColumnName = "prduct_id")
    private Product prduct_id;



    //@JsonBackReference
    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prduct_id", insertable = false, updatable = false)
    private Product product;
    */

}

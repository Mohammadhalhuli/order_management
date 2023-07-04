package com.pokemonreview.api.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class Stockdto {
    private Integer stock_id;
    private int quantity;
    private LocalDateTime updatedAt;
    //private Integer prduct_id;
}

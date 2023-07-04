package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.Orderdto;
import com.pokemonreview.api.service.impl.OrderDao;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public interface OrderServers {
    Orderdto add(Orderdto orderDto, Integer customerId);
}

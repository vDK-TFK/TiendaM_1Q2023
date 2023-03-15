package com.TiendaM_1Q2023.dao;

import com.TiendaM_1Q2023.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long> {
    
}

package com.TiendaM_1Q2023.dao;

import com.TiendaM_1Q2023.domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDao extends CrudRepository<Carrito, Long> {
    
    Optional<Carrito> findByidCliente(Long idCliente);
    
}

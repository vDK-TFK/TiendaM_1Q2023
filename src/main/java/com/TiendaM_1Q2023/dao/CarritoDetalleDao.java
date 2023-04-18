package com.TiendaM_1Q2023.dao;

import com.TiendaM_1Q2023.domain.Articulo;
import com.TiendaM_1Q2023.domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {
    
    List<CarritoDetalle> findByidCarrito(Long idCarrito);
    
    CarritoDetalle findByidCarritoAndArticulo(Long idCarrito, Articulo articulo);
    
    void deleteByidCarrito(Long idCarrito);
    
}

package com.TiendaM_1Q2023.service;

import com.TiendaM_1Q2023.dao.CarritoDao;
import com.TiendaM_1Q2023.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceimpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;
    
    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(Long idCliente) {
        // buscamos si existe el carrito para el cliente
        Carrito carritoCliente = carritoDao.findByidCliente(idCliente).orElse(null);
        
        // si no existe el carrito, lo creamos
        if (carritoCliente == null) {
            Carrito carritoNuevo = new Carrito(idCliente);
            carritoDao.save(carritoNuevo);
        }
        return carritoCliente;
    }
    
}

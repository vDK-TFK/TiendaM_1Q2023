package com.TiendaM_1Q2023.service;

import com.TiendaM_1Q2023.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> getClientes(); //obtener todos los clientes
    
    public Cliente getCliente(Cliente cliente); //un cliente en especifico
    
    public void save(Cliente cliente); //insertar nuevo registro o modificar (si viene el id cliente o no)
    
    public void delete(Cliente cliente); //eliminar
    
}

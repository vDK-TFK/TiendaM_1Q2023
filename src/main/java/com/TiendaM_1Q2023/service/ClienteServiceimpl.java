package com.TiendaM_1Q2023.service;

import com.TiendaM_1Q2023.dao.ClienteDao;
import com.TiendaM_1Q2023.dao.CreditoDao;
import com.TiendaM_1Q2023.domain.Cliente;
import com.TiendaM_1Q2023.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceimpl implements ClienteService {

    //implementa la logica del ClienteService
    @Autowired
    ClienteDao clienteDao;

    @Autowired
    CreditoDao creditodao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditodao.save(credito);

        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
    @Override
    public List<Cliente> getClientePorNombre(String nombre) {
        return clienteDao.findByNombreContainingIgnoreCase(nombre);
    }
}

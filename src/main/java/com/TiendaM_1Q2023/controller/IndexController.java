package com.TiendaM_1Q2023.controller;

import com.TiendaM_1Q2023.dao.UsuarioDao;
import com.TiendaM_1Q2023.domain.Carrito;
import com.TiendaM_1Q2023.domain.CarritoDetalle;
import com.TiendaM_1Q2023.domain.Usuario;
import com.TiendaM_1Q2023.service.ArticuloService;
import com.TiendaM_1Q2023.service.CarritoDetalleService;
import com.TiendaM_1Q2023.service.CarritoService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    ArticuloService articuloService;
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    CarritoService carritoService;
    
    @Autowired
    CarritoDetalleService carritoDetalleService;
    
    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        
        //obtener usuario log
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        
        if(principal instanceof UserDetails) {
            user = (UserDetails)principal;
        }
        
        boolean esCliente = false;
        
        //calidar si es un usuario log
        if(user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            
            //validar si el usuario es un cliente
            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0) {
                esCliente = true;
                
                //Consultamos el carrito del cliente
                Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
                
                //Guardamos el carrito del cliente
                request.getSession().setAttribute("idCliente", usuario.getIdCliente());
                request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
                request.getSession().setAttribute("esCliente",  esCliente);
                
                //Consultar items de carrito
                List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
                model.addAttribute("cantidadArticulosCarrito", carritoDetalles.size());
            }
        }
        
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);
        
               
        return "index";
    }     
}

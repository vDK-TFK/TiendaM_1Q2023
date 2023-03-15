package com.TiendaM_1Q2023.service;

import com.TiendaM_1Q2023.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activos); //obtener todos los articulos

    public Articulo getArticulo(Articulo articulo); //un articulo en especifico

    public void save(Articulo articulo); //insertar nuevo registro o modificar (si viene el id articulo o no)

    public void delete(Articulo articulo); //eliminar
}

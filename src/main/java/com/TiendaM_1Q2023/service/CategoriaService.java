package com.TiendaM_1Q2023.service;

import com.TiendaM_1Q2023.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos); //obtener todos los categorias
    
    public Categoria getCategoria(Categoria categoria); //un categoria en especifico
    
    public void save(Categoria categoria); //insertar nuevo registro o modificar (si viene el id categoria o no)
    
    public void delete(Categoria categoria); //eliminar
    
}

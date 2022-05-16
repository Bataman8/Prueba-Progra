/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelClienteParcial;

/**
 *
 * @author USUARIO
 */
public interface CrudClienteParcial {
    public List listar();
    public ModelClienteParcial list (int id);
    public boolean insertar(ModelClienteParcial cliente);
    public boolean modificar(ModelClienteParcial cliente);
    public boolean eliminar(ModelClienteParcial cliente);
}

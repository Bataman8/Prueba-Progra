/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.models.ModelClienteParcial;
import org.interfaces.CrudClienteParcial;

/**
 *
 * @author USUARIO
 */
public class DaoClienteParcial implements CrudClienteParcial {

    ModelClienteParcial cliente = new ModelClienteParcial();
    String strSql = "";
    Conexion conexion = new Conexion();
    ResultSet rs = null;
    boolean respuesta = false;

    @Override
    public List listar() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<ModelClienteParcial> lstCliente = new ArrayList<>();
        try {
            strSql = "select c.ID_CLIENTE, c.NOMBRE, c.APELLIDO, c.SALDO, tc.DESCRIPCION TIPO,c.ESTADO, c.FECHA_INICIO,\n"
                    + "case when c.ESTADO = 1 then 'ACTIVO' else 'INACTIVO' end descestado\n"
                    + "from CLIENTE C\n"
                    + "join TIPO_CLIENTE tc\n"
                    + "on c.ID_TIPO_CLIENTE= tc.ID_TIPO_CLIENTE ";
            System.out.println(strSql);
            conexion.open();
             System.out.println(strSql);
            rs = conexion.executeQuery(strSql);
 System.out.println(strSql);
            while (rs.next()) {
                ModelClienteParcial clie = new ModelClienteParcial();
                clie.setIdcliente(rs.getInt("ID_CLIENTE"));
                clie.setNombre(rs.getString("NOMBRE"));
                clie.setApellido(rs.getString("APELLIDO"));
                clie.setSaldo(rs.getDouble("SALDO"));
                clie.setIdtipocliente(rs.getInt("ID_TIPO_CLIENTE"));
                clie.setEstado(rs.getInt("ESTADO"));
                clie.setFechainicio(rs.getDate("FECHA_INICIO"));
                clie.setTipo(rs.getString("TIPO"));
                clie.setDescEstado(rs.getString("DESCESTADO"));
                lstCliente.add(clie);
            }
            rs.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoClienteParcial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DaoClienteParcial.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCliente;
    }

    @Override
    public ModelClienteParcial list(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {            
            strSql = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                cliente.setIdcliente(rs.getInt("ID_CLIENTE"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApellido(rs.getString("APELLIDO"));
                cliente.setSaldo(rs.getDouble("SALDO"));
                cliente.setIdtipocliente(rs.getInt("DI_TIPO_CLIENTE"));  
                cliente.setEstado(rs.getInt("ESTADO"));
                cliente.setFechainicio(rs.getDate("FECHA_INICIO"));
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoClienteParcial.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoClienteParcial.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return cliente;
    
    }

    @Override
    public boolean insertar(ModelClienteParcial cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ModelClienteParcial cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ModelClienteParcial cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

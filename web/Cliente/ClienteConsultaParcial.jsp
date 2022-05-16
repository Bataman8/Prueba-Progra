<%-- 
    Document   : ClienteConsulta
    Created on : 10/03/2022, 08:08:47 PM
    Author     : USUARIO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.models.ModelClienteParcial"%>
<%@page import="org.dao.DaoClienteParcial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">            
            <h1>Cliente</h1>
            <a class="btn btn-success" href="ControllerClienteParcial?accion=nuevo"  > Agregar Nuevo</a>
                <table border="1" width="1" cellspacing="1" class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Nombre</th>
                            <th class="text-center">Apellido</th>
                            <th class="text-center">Saldo</th>
                            <th class="text-center">Id Tipo Cliente</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">Fecha Inicio</th>
                            <th class="text-center">Tipo</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <%
                        DaoClienteParcial daoCliente = new  DaoClienteParcial();
                        List<ModelClienteParcial> lstCliente = daoCliente.listar();
                        Iterator<ModelClienteParcial> iteratorCliente = lstCliente.iterator();
                        ModelClienteParcial cliente = null;
                        while (iteratorCliente.hasNext()){
                            cliente = iteratorCliente.next();                        
                    %>                     
                    <tbody>
                        <tr>
                            <td class="text-center"><%= cliente.getIdcliente()%></td>
                            <td class="text-center"><%= cliente.getNombre()%></td>
                            <td class="text-center"><%= cliente.getApellido()%></td>
                            <td class="text-center"><%= cliente.getSaldo()%></td>
                            <td class="text-center"><%= cliente.getIdtipocliente()%></td>
                            <td class="text-center"><%= cliente.getDescEstado()%></td>
                            <td class="text-center"><%= cliente.getEstado()%></td>
                            <td class="text-center"><%= cliente.getFechainicio()%></td>
                            <td class="text-center"><%= cliente.getTipo()%></td>
                            <td class="text-center">                                
                                <a href="ControllerClienteParcial?accion=editar&id=<%=cliente.getIdcliente()%>">Editar</a>
                                <a href="ControllerClienteParcial?accion=delete&id=<%=cliente.getIdcliente()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
                   

            
        </div>
    </body>
</html>

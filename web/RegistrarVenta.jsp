<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html> <html lang="es"> <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>Ventas</title>
        <style>
            @media print{
                .parte01, .btn, .accion, .impr{
                    display: none;
                }
            }
        </style>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Código">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nombrescliente" value="${c.getNom()}" placeholder="Datos Cliente" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoproducto" class="form-control" value="${producto.getId()}" placeholder="Código">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${productoPrecio}" class="form-control" placeholder="$/.0.00">                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="number" name="cant" value="1" placeholder="" class="form-control">
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="text" name="stock" value="${productoStock}" placeholder="Stock" class="form-control">                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div> 
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>Nro.Serie:  </label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr class="text-center">
                                    <th>Nro</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%@page import="java.util.List"%>
                                <%@page import="Modelo.Venta" %>
                                <%
                                List<Venta> ventas = (List<Venta>) request.getAttribute("lista");
                                if(ventas!=null){
                                for(Venta v: ventas){
                                %>
                                <tr>
                                    <td><%=v.getItem()%></td>
                                    <td><%=v.getIdproducto()%></td>
                                    <td><%=v.getDescripcionP()%></td>
                                    <td><%=v.getPrecio()%></td>
                                    <td><%=v.getCantidad()%></td>
                                    <td><%=v.getSubtotal()%></td>
                                    <td class="d-flex">
                                        <div class="impr">
                                             <a class="btn btn-warning" href="Controlador?menu=NuevaVenta&accion=Editar&id=${v.getId()}">Editar</a>
                                                <a class="btn btn-danger" href="Controlador?menu=NuevaVenta&accion=Delete&id=${v.getId()}">Delete</a>
                                        </div></td>
                                </tr>
                                <%}
                              }%>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6 impr">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-info">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="co-sm-4 ml-auto">
                            <input type="text" name="txttotal" value="$/. ${totalpagar}" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.Double.parseDouble;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dagn6
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente cl = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;
    int idv;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item = 0;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;
    VentaDAO vdao = new VentaDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = cdao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDnicliente");
                    String nom = request.getParameter("txtNombrescliente");
                    String dir = request.getParameter("txtDireccioncliente");
                    String est = request.getParameter("txtEstadocliene");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDireccion(dir);
                    cl.setEstado(est);
                    cdao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDnicliente");
                    String nom1 = request.getParameter("txtNombrescliente");
                    String dir1 = request.getParameter("txtDireccioncliente");
                    String est1 = request.getParameter("txtEstadocliene");
                    cl.setDni(dni1);
                    cl.setNom(nom1);
                    cl.setDireccion(dir1);
                    cl.setEstado(est1);
                    cl.setId(idc);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("empleado.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {

            switch (accion) {
                case "Listar":
                    List lista = pdao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNom");//se obtiene datos de caja de texto
                    String pre = request.getParameter("txtPre");
                    String sto = request.getParameter("txtSto");
                    String estado = request.getParameter("txtEstado");
                    p.setNom(nom);//se guardan en cada variable por medio de la clase empleado
                    p.setPre(pre);
                    p.setSto(sto);
                    p.setEstado(estado);
                    pdao.agregar(p);//se gurdan datos de clase producto en la bd por medio del metodo agregar de ProductoDAO
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del producto.jsp
                    Producto p1 = pdao.listarId(idp);
                    request.setAttribute("producto", p1);//enaviar informacion al formulario Producto.jsp
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                    break;
                case "Actualizar":
                    String nom1 = request.getParameter("txtNom");//se obtiene datos de caja de texto
                    String pre1 = request.getParameter("txtPre");
                    String sto1 = request.getParameter("txtSto");
                    String estado1 = request.getParameter("txtEstado");
                    p.setNom(nom1);//se guardan en cada variable por medio de la clase empleado
                    p.setPre(pre1);
                    p.setSto(sto1);
                    p.setEstado(estado1);
                    p.setId(idp);
                    pdao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                    break;
                case "Delete":
                    idp = Integer.parseInt(request.getParameter("id"));//guardando el id que llega del producto.jsp
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);//para actualizar la tabla con los nuevos datos
                    break;
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);

        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("c", cl);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    String codigoProducto = request.getParameter("codigoproducto");
                    if (codigoProducto != null) {
                        int id = Integer.parseInt(codigoProducto);
                        p = pdao.listarId(id);
                        if (p != null) {
                            request.setAttribute("producto", p);
                            request.setAttribute("productoPrecio", p.getPre());
                            request.setAttribute("productoStock", p.getSto());
                            request.setAttribute("lista", lista);
                            request.setAttribute("totalpagar", totalPagar);
                            request.setAttribute("c", cl);
                            request.setAttribute("nserie", numeroserie);
                        } else {
                            request.setAttribute("error", "Producto no encontrado");
                        }
                    } else {
                        request.setAttribute("error", "Código de producto no encontrado");
                    }
                    break;
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", cl);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nomproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);

                    int stockActual = Integer.parseInt(p.getSto());
                    stockActual -= cant;
                    p.setSto(String.valueOf(stockActual));
                    pdao.actualizar(p);

                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar += lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    for (int i = 0; i < lista.size(); i++) {
                        Producto producto = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int idproducto = lista.get(i).getIdproducto();
                        ProductoDAO productoDAO = new ProductoDAO();
                        producto = productoDAO.buscar(idproducto);
                        int stockActualizado = Integer.valueOf(producto.getSto()) - cantidad;
                        productoDAO.actualizarstock(idproducto, stockActualizado);
                    }
                    v.setIdcliente(Integer.valueOf(cl.getId()));
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    LocalDate fechaActual = LocalDate.now();
                    String fechaFormateada = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    v.setFecha(fechaFormateada);
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    // Guardar Detalle ventas
                    int idVenta = Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        Venta ventaDetalle = new Venta();
                        ventaDetalle.setId(idVenta);
                        ventaDetalle.setIdproducto(lista.get(i).getIdproducto());
                        ventaDetalle.setCantidad(lista.get(i).getCantidad());
                        ventaDetalle.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(ventaDetalle);
                    }
                    break;
                case "Delete":
                    String idParam = request.getParameter("id");
                    if (idParam != null && !idParam.isEmpty()) {
                        idv = Integer.parseInt(idParam);
                        vdao.delete(idv);
                        request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
                    } else {
                        // Maneja el caso en que el parámetro id esté vacío
                        request.setAttribute("error", "No se proporcionó un ID válido");
                        request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
                    }
                    break;
                default:
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.Numeroserie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

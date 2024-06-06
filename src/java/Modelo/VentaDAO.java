package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    //Venta ve = new Venta();
    int r;

    public String GenerarSerie() {//se captura el maximo numero de serie de la bd
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error generarVenta en ventaDAo " + e);
        }
        return numeroserie;
    }

    public String IdVentas() {
        String idventas = "";
        String sql = "select max(IdVentas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error idVentas en ventaDAo " + e);
        }
        return idventas;
    }
public int guardarDetalleventas(Venta v){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta)values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setInt(2, v.getIdproducto());
            ps.setInt(3, v.getCantidad());
            ps.setDouble(4, v.getPrecio());
            ps.executeUpdate();
            
        }catch(Exception e){
            
        }
        return r;
    }

    public int guardarVenta(Venta v) {
        String sql = "insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdempleado());
            ps.setString(3, v.getNumserie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getPrecio());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error guardarVenta en ventaDAo " + e);
        }
        return r;
    }

    public void delete(int idVenta) {
        String sql = "DELETE FROM ventas WHERE IdVentas = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la venta: " + e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ex) {
                System.out.println("Error al cerrar conexiones: " + ex);
            }
        }
    }

}

/*
 * 
 */
package eje7bol7_1;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Eje7bol7_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex) {
            System.out.println("Error");
        }
        
        Connection con;
        String url="jdbc:mysql://localhost/Empresa";
        try{
            con = DriverManager.getConnection(url,
                                            "root",
                                            "root");
            System.out.println("Conectados");
            System.out.println("numemp?");
            int numemp = new Scanner(System.in).nextInt();
            //antes de pedir más datos comprobamos si se puede insertar
        if (comprobarEmp(numemp)) {
            System.out.println("El empleado ya existe");
        } else {
            System.out.println("oficina?");
            int oficina = new Scanner(System.in).nextInt();

            //comprobar la oficina
            if (!comprobarOfi(oficina)) {
                System.out.println("Error: la oficina no existe");
            } else {
                System.out.println("jefe?");
                int jefe = new Scanner(System.in).nextInt();

                if (!comprobarEmp(jefe)) {
                    System.out.println("Error: no existe el jefe");
                } else {
                    //todas las comprobaciones bien
                    //pedimos el resto de los datos
                    System.out.println("Ventas?");
                    int ventas = new Scanner(System.in).nextInt();
                    System.out.println("Título?");
                    String titulo = new Scanner(System.in).nextLine();

                    //insertamos
                    String sql = "INSERT INTO Empleados "
                            + "(numemp, oficina, jefe, ventas, titulo) VALUES ("
                            + numemp + ", " + oficina + ", " + jefe + ", "
                            + ventas + ", '" + titulo + "');";
                    con = conecta();
                    ejecutaUpdate(con, sql);
                }
            }
        }

            con.close();
            }
        
 
        catch(SQLException ex){
            System.out.println("Error de conexion");
        }
    }
    
/* En la conexión pasada ejecuta la sentencia sql (que debe ser un UPDATE, INSERT o DELETE)
 * En este caso no se devuelve nada. */
    static void ejecutaUpdate(Connection con, String sql) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }
    }
    
    public static boolean comprobarEmp(int numemp) {
        
        Connection con = conecta();
        ResultSet rs = ejecuta(con, "Select * From Empleados Where numemp = "+numemp+";");
        boolean existe = false;

        try {
            rs.next();
            existe = true;
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        return existe;
    }
    
    static boolean comprobarOfi(int oficina) {
        Connection con = conecta();
        ResultSet rs = ejecuta(con,
                "SELECT * FROM Oficinas WHERE oficina = " + oficina + ";");

        boolean existe = false;

        try {
            rs.next();
            existe = true;
            
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        return existe;
    }
    
    static ResultSet ejecuta(Connection con, String sql) {
        ResultSet rs = null;

        Statement sentencia;
        try {
            sentencia = con.createStatement();
            rs = sentencia.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("Error SQL");
        }

        return rs;
    }
    
    private static Connection conecta() {
        Connection con = null;
        try {
            // Realizamos la conexión
            con = DriverManager.getConnection("jdbc:mysql://localhost/Empresa",
                    "root",
                    "root");
            // se puede conectar
        } catch (SQLException e) {
            System.out.println("Error de conexión");
        }

        return con;
    }
}

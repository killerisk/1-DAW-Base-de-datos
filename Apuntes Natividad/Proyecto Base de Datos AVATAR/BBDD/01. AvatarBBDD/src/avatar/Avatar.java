package avatar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Avatar {

    private static String host = "localhost";
    private static String database = "avatar";
    private static String username = "root";
    private static String password = "";

    public static void main(String[] args) {
        int opcion;
        Connection con = conectar();

        do {
            opcion = PintarMenu();

            switch (opcion) {
                case 10:
                    ListarSocios(con);
                    break;
                case 11:
                    CrearSocio(con);
                    break;
                case 12:
                    System.out.println("Lista de socios. Luego, pulse intro para modificar: ");
                    ListarSocios(con);
                    System.out.println("");
                    ModificarSocios(con);
                    break;
                case 13:
                    System.out.println("Lista de socios. Luego, pulse intro para borrar: ");
                    ListarSocios(con);
                    System.out.println("");
                    BorrarSocio(con);
                    break;
                case 14:
                    AsignarActividadSocio(con);
                    break;
                case 15:
                    DesasignarActividadSocio(con);
                    break;
                case 20:
                    ListarResponsables(con);
                    break;
                case 21:
                    CrearResponsable(con);
                    break;
                case 22:
                    System.out.println("Lista de responsables. Luego, pulse intro para modificar: ");
                    ListarResponsables(con);
                    System.out.println("");
                    ModificarResponsable(con);
                    break;
                case 23:
                    System.out.println("Lista de responsables. Luego, pulse intro para borrar: ");
                    ListarResponsables(con);
                    System.out.println("");
                    BorrarResponsable(con);
                    break;
                case 30:
                    ListarSalas(con);
                    break;
                case 31:
                    CrearSalas(con);
                    break;
                case 32:
                    System.out.println("Lista de salas. Luego, pulse intro para modificar: ");
                    ListarSalas(con);
                    System.out.println("");
                    ModificarSalas(con);
                    break;
                case 33:
                    System.out.println("Lista de salas. Luego, pulse intro para borrar: ");
                    ListarSalas(con);
                    System.out.println("");
                    BorrarSalas(con);
                    break;
                case 40:
                    ListarActividades(con);
                    break;
                case 41:
                    CrearActividad(con);
                    break;
                case 42:
                    System.out.println("Lista de actividades. Luego, pulse intro para modificar: ");
                    ListarActividades(con);
                    System.out.println("");
                    ModificarActividad(con);
                    break;
                case 43:
                    System.out.println("Lista de actividades. Luego, pulse intro para borrar: ");
                    ListarActividades(con);
                    System.out.println("");
                    BorrarActividad(con);
                    break;
                case 44:
                    AsignarActividadResponsable(con);
                    break;
                case 45:
                    AsignarActividadSala(con);
                    break;
                case 46:
                    AsignarActividadSocio(con);
                    break;
                case 47:
                    DesasignarActividadSocio(con);
                    break;
                case 48:
                    AsignarActividadCliente(con);
                    break;
                case 49:
                    DesasignarActividadCliente(con);
                    break;
                case 50:
                    ListarClientes(con);
                    break;
                case 51:
                    CrearCliente(con);
                    break;
                case 52:
                    System.out.println("Lista de clientes. Luego, pulse intro para modificar: ");
                    ListarClientes(con);
                    System.out.println("");
                    ModificarCliente(con);
                    break;
                case 53:
                    System.out.println("Lista de clientes. Luego, pulse intro para borrar: ");
                    ListarClientes(con);
                    System.out.println("");
                    BorrarCliente(con);
                    break;
                case 60:
                    MostrarAgenda(con);
                    break;
                case 61: 
                    AgregarAgenda(con);
                    break;
                case 62:
                    BorrarAgenda(con);
                    break;
                case 63:
                    Horario(con);
                    break;
                case 64:
                    HorarioHoy(con);
                    break;
                case 65:
                    ActividadesXDias(con);
                    break;
                case 70:
                    ConsultaDeAgregadosSocios(con);
                    break;
                case 71:
                    ConsultaDeAgregadosClientes(con);
                    break;
            }
        } while (opcion != 100);

        cerrarConexion(con);
    }

    private static int PintarMenu() {
        int res = ' ';

        do {
            Scanner sc = new Scanner(System.in);

            LimpiarPantalla();
            System.out.println("BIENVENIDOS A LA ASOCIACIÓN AVATAR");
            System.out.println("==================================");
            System.out.println("\tSocios.");
            System.out.println("\t\t010.- Listar Socios.");
            System.out.println("\t\t011.- Crear Socio.");
            System.out.println("\t\t012.- Modificar Socios.");
            System.out.println("\t\t013.- Borrar Socio.");
            System.out.println("\t\t014.- Asignar actividad con socios.");
            System.out.println("\t\t015.- Desasignar actividad con socios.\n");
            System.out.println("\tResponsables.");
            System.out.println("\t\t020.- Listar Responsables.");
            System.out.println("\t\t021.- Crear Responsables.");
            System.out.println("\t\t022.- Modificar Responsables.");
            System.out.println("\t\t023.- Borrar Responsables.\n");
            System.out.println("\tSalas.");
            System.out.println("\t\t030.- Listar Salas.");
            System.out.println("\t\t031.- Crear Salas.");
            System.out.println("\t\t032.- Modificar Salas.");
            System.out.println("\t\t033.- Borrar Salas.\n");
            System.out.println("\tActividades.");
            System.out.println("\t\t040.- Listar Actividades.");
            System.out.println("\t\t041.- Crear Actividad.");
            System.out.println("\t\t042.- Modificar Actividad.");
            System.out.println("\t\t043.- Borrar Actividad.");
            System.out.println("\t\t044.- Asignar actividad con responsable.");
            System.out.println("\t\t045.- Asignar actividad con sala.");
            System.out.println("\t\t046.- Asignar actividad con socios.");
            System.out.println("\t\t047.- Desasignar actividad con socios.");
            System.out.println("\t\t048.- Asignar actividad con clientes.");
            System.out.println("\t\t049.- Desasignar actividad con clientes.\n");
            System.out.println("\tClientes.");
            System.out.println("\t\t050.- Listar Clientes.");
            System.out.println("\t\t051.- Crear Cliente.");
            System.out.println("\t\t052.- Modificar Cliente.");
            System.out.println("\t\t053.- Borrar Cliente.\n");
            System.out.println("\tAgenda.");
            System.out.println("\t\t060.- Mostrar Agenda.");
            System.out.println("\t\t061.- Agregar Agenda.");
            System.out.println("\t\t062.- Borrar Agenda.");
            System.out.println("\t\t063.- Horario.");
            System.out.println("\t\t064.- Horario de hoy.");
            System.out.println("\t\t065.- Actividades por días.\n");
            System.out.println("\tConsultas Complejas.");
            System.out.println("\t\t070.- Consulta de agregadosSocios.");
            System.out.println("\t\t071.- Consulta de agregadosClientes.\n");
            System.out.println("Introduzca una opción (100 para salir): ");

            try {
                res = sc.nextInt();
            } catch (Exception ex) {
                res = -1;
            }
        } while (res != 10 && res != 11 && res != 12 && res != 13 && res != 14 && res !=15
                && res != 20 && res != 21 && res != 22 && res != 23
                && res != 30 && res != 31 && res != 32 && res != 33
                && res != 40 && res != 41 && res != 42 && res != 43 && res != 44 && res != 45 && res != 46 && res != 47 && res != 48 && res != 49
                && res != 50 && res != 51 && res != 52 && res != 53
                && res != 60 && res != 61 && res != 62 && res != 63 && res != 64 && res != 65
                && res != 70 && res !=71
                && res != 100);

        return res;
    }

    private static void LimpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    private static void ListarSalas(Connection conexion) {
        try {
            String consulta = " select * from Salas ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\nLISTAR SALAS");
            System.out.println("============");

            while (rs.next()) {
                String resultado = "\tidSala: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);
                resultado += "; Número: " + rs.getInt(3);
                resultado += "; Capacidad: " + rs.getString(4);

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void CrearResponsable(Connection conexion) {
        String sql = " INSERT INTO `Responsables`(`dniResp`, `nombre`, `donativo`) VALUES (";
        Scanner sc = new Scanner(System.in);
        int dniResp = 0;
        String nombre = "";
        int donativo = 0;

        try {
            System.out.println("\nCREAR RESPONSABLE");
            System.out.println("============");

            System.out.println("Introduzca el dni del responsable: ");
            dniResp = sc.nextInt();
            System.out.println("Introduzca el nombre del responsable: ");
            nombre = (new Scanner(System.in)).nextLine();
            System.out.println("Introduzca el donativo del responsable: ");
            donativo = sc.nextInt();
            sql = sql + dniResp + ", '" + nombre + "', " + donativo + ")";
            ejecutaUpdate(conexion, sql);
            System.out.println("El responsable ha sido creado.");

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ListarResponsables(Connection conexion) {
        try {
            String consulta = " select * from Responsables; ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\nLISTAR RESPONSABLES");
            System.out.println("=============");

            while (rs.next()) {
                String resultado = "\tdniResp: " + rs.getInt(1);

                resultado += "; Nombre: " + rs.getString(2);
                resultado += "; Donativo: " + rs.getInt(3) + "€";

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void CrearSocio(Connection conexion) {
        String sql = " INSERT INTO `Socios`(`nombre`, `cuota`) VALUES ('";
        String nombre = "";
        int cuota = 20;

        try {
            System.out.println("\nCREAR SOCIOS");
            System.out.println("============");

            System.out.println("Introduzca el nombre del socio: ");
            nombre = (new Scanner(System.in)).nextLine();
            //la cuota para todos los socios es de 20€
            sql = sql + nombre + "', " + cuota + ")";
            ejecutaUpdate(conexion, sql);
            System.out.println("El socio ha sido creado.");

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ModificarSocios(Connection conexion) {
        String sql = " UPDATE `Socios` SET `nombre` = '%s'  WHERE `idSocio` = %d; ";
        String sql2 = " SELECT idSocio, nombre, cuota FROM Socios where idSocio = ";
        String nombre = "";
        int idSocio = -1;

        try {
            System.out.println("\nMODIFICAR SOCIOS");
            System.out.println("================");

            System.out.println("Introduzca el idSocio a modificar: ");
            idSocio = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = sql2 + idSocio + " ";
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el socio no existe
                System.out.println("El socio no existe.");
            } else {
                // modificamos el socio
                System.out.println("Introduzca el nombre del socio: ");
                nombre = (new Scanner(System.in)).nextLine();
                sql = String.format(sql, nombre, idSocio);
                ejecutaUpdate(conexion, sql);
                System.out.println("El socio se ha modificado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void BorrarSocio(Connection conexion) {
        String sql = " DELETE FROM Socios WHERE idSocio = ";
        String sql2 = " SELECT idSocio, nombre, cuota FROM Socios where idSocio = ";
        int idSocio = -1;

        try {
            System.out.println("\nBORRAR SOCIOS");
            System.out.println("=============");

            System.out.println("Introduzca el idSocio a borrar: ");
            idSocio = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = sql2 + idSocio + " ";
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el socio no existe
                System.out.println("El socio no existe.");
            } else {
                // borramos el socio
                sql = sql + idSocio + " ";
                ejecutaUpdate(conexion, sql);
                System.out.println("El socio se ha borrado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ListarSocios(Connection conexion) {
        try {
            String consulta = " select * from Socios; ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\nLISTAR SOCIOS");
            System.out.println("=============");

            while (rs.next()) {
                String resultado = "\tIdSocio: " + rs.getInt(1);

                resultado += "; Nombre: " + rs.getString(2);
                resultado += "; Cuota: " + rs.getInt(3) + "€";

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static Connection conectar() {
        Connection con = null;

        try {

            /**
             * ** Realizamos la conexión ***
             */
            con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
            /**
             * ** Ok: avisamos ***
             */
            System.out.println("Conectados...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return con;
    }

    private static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Desconectados...");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static ResultSet ejecutaQuery(Connection conexion, String sql) {
        Statement sentencia;
        ResultSet rs = null;

        try {
            sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    private static void ejecutaUpdate(Connection conexion, String sql)
            throws SQLException {
        Statement sentencia;

        sentencia = conexion.createStatement();
        sentencia.executeUpdate(sql);
    }

    private static void ModificarResponsable(Connection conexion) {
        String sql = " UPDATE Responsables SET nombre = '%s', donativo = %d WHERE dniResp = %d; ";
        String sql2 = " SELECT dniResp, nombre, donativo FROM Responsables WHERE dniResp = %d ";
        String nombre = "";
        int donativo = 0;
        int dniResp = -1;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nMODIFICAR RESPONSABLE");
            System.out.println("=====================");

            System.out.println("Introduzca el DNI del responsable a modificar: ");
            dniResp = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, dniResp);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el responsable no existe
                System.out.println("El responsable no existe.");
            } else {
                // modificamos el responsable
                System.out.println("Introduzca el nombre del responsable: ");
                nombre = sc.nextLine();
                System.out.println("Introduzca el donativo del responsable: ");
                donativo = sc.nextInt();
                sql = String.format(sql, nombre, donativo, dniResp);
                ejecutaUpdate(conexion, sql);
                System.out.println("El responsable se ha modificado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void BorrarResponsable(Connection conexion) {
        String sql = " DELETE FROM `Responsables` WHERE dniResp = %d; ";
        String sql2 = " SELECT dniResp, nombre, donativo FROM Responsables WHERE dniResp = %d ";
        int dniResp = -1;

        try {
            System.out.println("\nBORRAR RESPONSABLE");
            System.out.println("==================");
            System.out.println("Introduzca el dni del responsable a borrar: ");
            dniResp = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, dniResp);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el responsable no existe
                System.out.println("El responsable no existe.");
            } else {
                // borramos el responsable
                sql = String.format(sql, dniResp);
                ejecutaUpdate(conexion, sql);
                System.out.println("El responsable se ha borrado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void CrearSalas(Connection conexion) {
        String sql = " INSERT INTO `Salas` (`nombre`, `numero`, `capacidad`) VALUES ('%s',%d,'%s'); ";
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int numero = 0;
        int isize = 0;
        String ssize = "pequeña";

        try {
            System.out.println("\nCREAR SALAS");
            System.out.println("===========");

            System.out.println("Introduzca el nombre de la sala: ");
            nombre = (new Scanner(System.in)).nextLine();
            System.out.println("Introduzca el número de la puerta de la sala: ");
            numero = sc.nextInt();
            System.out.println("Introduzca el tamaño de la sala (1: pequeña, 2: mediana, 3: grande): ");
            isize = sc.nextInt();

            switch (isize) {
                case 1:
                    ssize = "pequeña";
                    break;
                case 2:
                    ssize = "mediana";
                    break;
                case 3:
                    ssize = "grande";
                    break;
                default:
                    ssize = "pequeña";
            }

            sql = String.format(sql, nombre, numero, ssize);

            ejecutaUpdate(conexion, sql);
            System.out.println("La sala ha sido creada.");
            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ModificarSalas(Connection conexion) {
        String sql = " UPDATE `Salas` SET `nombre` = '%s', `numero` = %d, `capacidad` = '%s' WHERE `idSala` = %d; ";
        String sql2 = " SELECT idSala, nombre, numero, capacidad FROM Salas where idSala = %d; ";
        String nombre = "";
        int idSala = -1;
        int numero = 0;
        int isize = 0;
        String ssize = "pequeña";
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nMODIFICAR SALA");
            System.out.println("==============");

            System.out.println("Introduzca el idSala de la sala a modificar: ");
            idSala = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idSala);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // la sala no existe
                System.out.println("La sala no existe.");
            } else {
                // modificamos la sala
                System.out.println("Introduzca el nombre de la sala: ");
                nombre = (new Scanner(System.in)).nextLine();
                System.out.println("Introduzca el número de la puerta de la sala: ");
                numero = sc.nextInt();
                System.out.println("Introduzca el tamaño de la sala (1: pequeña, 2: mediana, 3: grande): ");
                isize = sc.nextInt();

                switch (isize) {
                    case 1:
                        ssize = "pequeña";
                        break;
                    case 2:
                        ssize = "mediana";
                        break;
                    case 3:
                        ssize = "grande";
                        break;
                    default:
                        ssize = "pequeña";
                }

                sql = String.format(sql, nombre, numero, ssize, idSala);

                ejecutaUpdate(conexion, sql);
                System.out.println("La sala se ha modificado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void BorrarSalas(Connection conexion) {
        String sql = " DELETE FROM `Salas` WHERE idSala = %d; ";
        String sql2 = " SELECT idSala, nombre, numero, capacidad FROM Salas where idSala = %d; ";
        int dniResp = -1;

        try {
            System.out.println("\nBORRAR SALA");
            System.out.println("===========");
            System.out.println("Introduzca el idSala a borrar: ");
            dniResp = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, dniResp);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // la sala no existe
                System.out.println("La sala no existe.");
            } else {
                // borramos la sala
                sql = String.format(sql, dniResp);
                ejecutaUpdate(conexion, sql);
                System.out.println("La sala se ha borrado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ListarActividades(Connection conexion) {
        try {
            String consulta = " SELECT a.idActividad, a.nombre, a.tipo, a.dniResp, a.idSala, r.nombre, s.nombre "
                    + " FROM Actividades a "
                    + " LEFT JOIN Responsables r on a.dniResp = r.dniResp "
                    + " LEFT JOIN Salas s on a.idSala = s.idSala ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\n\nLISTAR ACTIVIDADES");
            System.out.println("==================");

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);
                resultado += "; Tipo: " + rs.getString(3);
                resultado += "; Responsable: " + rs.getInt(4) + " (" + rs.getString(6) + ")";
                resultado += "; Sala: " + rs.getInt(5) + " (" + rs.getString(7) + ")";

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void CrearActividad(Connection conexion) {
        String sql = " INSERT INTO `Actividades` (`nombre`, `tipo`) VALUES ('%s','%s'); ";
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String tipo = "";

        try {
            System.out.println("\nCREAR ACTIVIDAD");
            System.out.println("===============");

            System.out.println("Introduzca el nombre de la actividad: ");
            nombre = (new Scanner(System.in)).nextLine();
            System.out.println("Introduzca el tipo de actividad: ");
            tipo = sc.nextLine();

            sql = String.format(sql, nombre, tipo);

            ejecutaUpdate(conexion, sql);
            System.out.println("La actividad ha sido creada.");
            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ModificarActividad(Connection conexion) {
        String sql = " UPDATE `Actividades` SET `nombre` = '%s', `tipo` = '%s' WHERE `idActividad` = %d; ";
        String sql2 = " SELECT idActividad, nombre, tipo, dniResp, idSala FROM Actividades WHERE idActividad = %d; ";
        String nombre = "";
        String tipo = "";
        int idActividad;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nMODIFICAR ACTIVIDAD");
            System.out.println("===================");

            System.out.println("Introduzca el idActividad de la actividad a modificar: ");
            idActividad = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idActividad);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // la actividad no existe
                System.out.println("La actividad no existe.");
            } else {
                // modificamos la actividad
                System.out.println("Introduzca el nombre de la actividad: ");
                nombre = sc.nextLine();
                System.out.println("Introduzca el tipo de la actividad: ");
                tipo = sc.nextLine();
                sql = String.format(sql, nombre, tipo, idActividad);

                ejecutaUpdate(conexion, sql);
                System.out.println("La actividad se ha modificado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void BorrarActividad(Connection conexion) {
        String sql = " DELETE FROM `Actividades` WHERE idActividad = %d; ";
        String sql2 = " SELECT idActividad, nombre, tipo, dniResp, idSala FROM Actividades WHERE idActividad = %d; ";
        int idActividad = -1;

        try {
            System.out.println("\nBORRAR ACTIVIDAD");
            System.out.println("================");
            System.out.println("Introduzca el idActividad a borrar: ");
            idActividad = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idActividad);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // la actividad no existe
                System.out.println("La actividad no existe.");
            } else {
                // borramos la actividad
                sql = String.format(sql, idActividad);
                ejecutaUpdate(conexion, sql);
                System.out.println("La actividad se ha borrado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void AsignarActividadResponsable(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` where idActividad = %d ; ";
        String sql2 = " SELECT `dniResp`, `nombre` FROM `Responsables`; ";
        String sql3 = " SELECT `dniResp`, `nombre` FROM `Responsables` WHERE dniResp = %d; ";
        String sql4 = " UPDATE `Actividades` SET `dniResp` = %d WHERE `idActividad` = %d; ";
        int idActividad = 0;
        int dniResp = 0;
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        ResultSet rs, rs1, rs2, rs3;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nASIGNAR ACTIVIDAD CON RESPONSABLE");
            System.out.println("=================================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de responsables: ");
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tdniResp: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el DNI del responsable a asignar con la actividad: ");
                dniResp = sc.nextInt();

                sql3 = String.format(sql3, dniResp);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && rs3.next()) {
                sql4 = String.format(sql4, dniResp, idActividad);
                ejecutaUpdate(conexion, sql4);

                System.out.println("La actividad ha sido actualizada con éxito.");
            } else if (seguir == true) {
                System.out.println("El responsable no existe.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void AsignarActividadSala(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` where idActividad = %d ; ";
        String sql2 = " SELECT `idSala`, `nombre` FROM `Salas`; ";
        String sql3 = " SELECT `idSala`, `nombre` FROM `Salas` WHERE `idSala` = %d; ";
        String sql4 = " UPDATE `Actividades` SET `idSala` = %d WHERE `idActividad` = %d; ";
        int idActividad = 0;
        int idSala = 0;
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        ResultSet rs, rs1, rs2, rs3;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nASIGNAR ACTIVIDAD CON SALAS");
            System.out.println("===========================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de salas: ");
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tidSala: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el id de la sala a asignar con la actividad: ");
                idSala = sc.nextInt();

                sql3 = String.format(sql3, idSala);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && rs3.next()) {
                sql4 = String.format(sql4, idSala, idActividad);
                ejecutaUpdate(conexion, sql4);

                System.out.println("La actividad ha sido actualizada con éxito.");
            } else if (seguir == true) {
                System.out.println("La sala no existe.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void AsignarActividadSocio(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` WHERE `idActividad` = %d; ";
        String sql2 = " select s.idSocio, s.nombre from Socios s where s.idSocio not in ( select ass.idSocio from ActividadesSocios ass where ass.idActividad = %d )  ";
        String sql3 = " select s.idSocio, s.nombre from Socios s where s.idSocio not in ( select ass.idSocio from ActividadesSocios ass where ass.idActividad = %d ) and s.idSocio = %d ";
        String sql4 = " INSERT INTO `ActividadesSocios` (`idSocio`, `idActividad`) VALUES (%d,%d); ";
        Scanner sc = new Scanner(System.in);
        int idActividad = 0;
        int idSocio = 0;
        ResultSet rs, rs1, rs2, rs3;
        boolean seguir = true;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nASIGNAR ACTIVIDAD CON SOCIOS");
            System.out.println("============================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de socios no relacionados con la actividad seleccionada: ");
                sql2 = String.format(sql2, idActividad);
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tIdSocio: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el id del socio a relacionar con la actividad");
                idSocio = sc.nextInt();

                sql3 = String.format(sql3, idActividad, idSocio);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && !rs3.next()) {
                seguir = false;
                System.out.println("El socio no es válido.");
            } else if (rs3 != null) {
                sql4 = String.format(sql4, idSocio, idActividad);

                ejecutaUpdate(conexion, sql4);
                System.out.println("La actividad ha sido relacionada con el socio correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void DesasignarActividadSocio(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` WHERE `idActividad` = %d; ";
        String sql2 = " select s.idSocio, s.nombre from Socios s join ActividadesSocios ass on s.idSocio = ass.idSocio where ass.idActividad = %d ";
        String sql3 = " select * from ActividadesSocios where idSocio = %d and idActividad = %d ";
        String sql4 = " DELETE FROM `ActividadesSocios` WHERE idSocio = %d and idActividad = %d ";
        Scanner sc = new Scanner(System.in);
        int idActividad = 0;
        int idSocio = 0;
        ResultSet rs, rs1, rs2, rs3;
        boolean seguir = true;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nDESASIGNAR ACTIVIDAD CON SOCIOS");
            System.out.println("===============================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de socios relacionados con la actividad seleccionada: ");
                sql2 = String.format(sql2, idActividad);
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tIdSocio: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el id del socio a desasignar con la actividad");
                idSocio = sc.nextInt();

                sql3 = String.format(sql3, idSocio, idActividad);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && !rs3.next()) {
                seguir = false;
                System.out.println("El socio no es válido.");
            } else if (seguir == true && rs3 != null) {
                sql4 = String.format(sql4, idSocio, idActividad);

                ejecutaUpdate(conexion, sql4);
                System.out.println("La actividad ha sido desasignada con el socio correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void MostrarAgenda(Connection conexion) {
        try {
            String consulta = " SELECT a.idAgenda,a.idDia,a.idActividad,a.horaInicio,a.horaFin,a.anyo, d.nombreDia, ac.nombre  FROM Agenda a  left join Dias d on a.idDia = d.idDia  left join Actividades ac on a.idActividad = ac.idActividad; ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\nMOSTRAR AGENDA");
            System.out.println("=============");

            while (rs.next()) {
                String resultado = "\tIdAgenda: " + rs.getInt(1);

                resultado += "; IdDia: " + rs.getString(2) + " (" + rs.getString(7) + ")";
                resultado += "; IdActividad: " + rs.getInt(3) + " (" + rs.getString(8) + ")";
                resultado += "; horaInicio: " + rs.getTime(4);
                resultado += "; horaFin: " + rs.getTime(5);
                resultado += "; anyo: " + rs.getInt(6);

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ListarClientes(Connection conexion) {
        try {
            String consulta = " SELECT idCLiente, nombre, precio FROM Clientes; ";
            ResultSet rs = ejecutaQuery(conexion, consulta);

            System.out.println("\nLISTAR CLIENTES");
            System.out.println("===============");

            while (rs.next()) {
                String resultado = "\tIdCliente: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);
                resultado += "; Precio por actividad: " + rs.getString(3) + "€";

                System.out.println(resultado);
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void CrearCliente(Connection conexion) {
        String sql = " INSERT INTO `Clientes` (`nombre`, `precio`) VALUES ('%s',%d); ";
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int precio;

        try {
            System.out.println("\nCREAR CLIENTE");
            System.out.println("=============");

            System.out.println("Introduzca el nombre del cliente: ");
            nombre = (new Scanner(System.in)).nextLine();
            System.out.println("Introduzca el precio a pagar por actividad: ");
            precio = sc.nextInt();

            sql = String.format(sql, nombre, precio);

            ejecutaUpdate(conexion, sql);
            System.out.println("El cliente ha sido creado.");
            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ModificarCliente(Connection conexion) {
        String sql = " UPDATE `Clientes` SET `nombre` = '%s', `precio` = %d WHERE `idCLiente` = %d; ";
        String sql2 = " SELECT idCLiente FROM Clientes where idCLiente = %d; ";
        String nombre = "";
        int idCliente;
        int precio;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\nMODIFICAR CLIENTE");
            System.out.println("=================");

            System.out.println("Introduzca el idCliente del cliente a modificar: ");
            idCliente = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idCliente);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el cliente no existe
                System.out.println("El cliente no existe.");
            } else {
                // modificamos el cliente
                System.out.println("Introduzca el nombre del cliente: ");
                nombre = sc.nextLine();
                System.out.println("Introduzca el precio por actividad a pagar: ");
                precio = sc.nextInt();
                sql = String.format(sql, nombre, precio, idCliente);

                ejecutaUpdate(conexion, sql);
                System.out.println("El cliente se ha modificado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void BorrarCliente(Connection conexion) {
        String sql = " DELETE FROM Clientes WHERE idCLiente = %d; ";
        String sql2 = " SELECT idCLiente FROM Clientes where idCLiente = %d; ";
        int idActividad = -1;

        try {
            System.out.println("\nBORRAR CLIENTE");
            System.out.println("==============");
            System.out.println("Introduzca el idCliente a borrar: ");
            idActividad = (new Scanner(System.in)).nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idActividad);
            ResultSet rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // la actividad no existe
                System.out.println("El cliente no existe.");
            } else {
                // borramos la actividad
                sql = String.format(sql, idActividad);
                ejecutaUpdate(conexion, sql);
                System.out.println("El cliente se ha borrado correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void AsignarActividadCliente(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` WHERE `idActividad` = %d; ";
        String sql2 = " select c.idCLiente, c.nombre from Clientes c where c.idCLiente not in ( select acc.idCliente from ActividadesClientes acc where acc.idActividad = %d )  ";
        String sql3 = " select c.idCLiente, c.nombre from Clientes c where c.idCLiente not in ( select acc.idCliente from ActividadesClientes acc where acc.idActividad = %d )  and c.idCLiente = %d ";
        String sql4 = " INSERT INTO `ActividadesClientes` (`idCliente`, `idActividad`) VALUES (%d,%d); ";
        Scanner sc = new Scanner(System.in);
        int idActividad = 0;
        int idCliente = 0;
        ResultSet rs, rs1, rs2, rs3;
        boolean seguir = true;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nASIGNAR ACTIVIDAD CON CLIENTES");
            System.out.println("==============================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de clientes no relacionados con la actividad seleccionada: ");
                sql2 = String.format(sql2, idActividad);
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tIdCliente: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el id del cliente a relacionar con la actividad");
                idCliente = sc.nextInt();

                sql3 = String.format(sql3, idActividad, idCliente);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && !rs3.next()) {
                seguir = false;
                System.out.println("El cliente no es válido.");
            } else if (rs3 != null) {
                sql4 = String.format(sql4, idCliente, idActividad);

                ejecutaUpdate(conexion, sql4);
                System.out.println("La actividad ha sido relacionada con el cliente correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void DesasignarActividadCliente(Connection conexion) {
        String sql = " SELECT `idActividad`, `nombre` FROM `Actividades`; ";
        String sql1 = " SELECT `idActividad`, `nombre` FROM `Actividades` WHERE `idActividad` = %d; ";
        String sql2 = " select c.idCLiente, c.nombre from Clientes c join ActividadesClientes acc on c.idCLiente = acc.idCliente  where acc.idActividad = %d ";
        String sql3 = " select * from ActividadesClientes where idCliente = %d and idActividad = %d ";
        String sql4 = " DELETE FROM ActividadesClientes WHERE idCliente = %d and idActividad = %d ";
        Scanner sc = new Scanner(System.in);
        int idActividad = 0;
        int idCliente = 0;
        ResultSet rs, rs1, rs2, rs3;
        boolean seguir = true;

        rs = null;
        rs1 = null;
        rs2 = null;
        rs3 = null;

        try {
            System.out.println("\nDESASIGNAR ACTIVIDAD CON CLIENTES");
            System.out.println("=================================");
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql);

            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }

            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            // primero buscamos si existe
            sql1 = String.format(sql1, idActividad);
            rs1 = ejecutaQuery(conexion, sql1);

            if (!rs1.next()) {
                // la actividad no existe
                seguir = false;
                System.out.println("La actividad no existe.");
            } else {
                seguir = true;
                System.out.println("Listado de clientes relacionados con la actividad seleccionada: ");
                sql2 = String.format(sql2, idActividad);
                rs2 = ejecutaQuery(conexion, sql2);
            }

            while (seguir == true && rs2.next()) {
                String resultado = "\tIdCliente: " + rs2.getString(1);
                resultado += "; Nombre: " + rs2.getString(2);

                System.out.println(resultado);
            }

            if (seguir == true) {
                System.out.println("Introduzca el id del cliente a desasignar con la actividad");
                idCliente = sc.nextInt();

                sql3 = String.format(sql3, idCliente, idActividad);
                rs3 = ejecutaQuery(conexion, sql3);
            }

            if (seguir == true && !rs3.next()) {
                seguir = false;
                System.out.println("El cliente no es válido.");
            } else if (seguir == true && rs3 != null) {
                sql4 = String.format(sql4, idCliente, idActividad);

                ejecutaUpdate(conexion, sql4);
                System.out.println("La actividad ha sido desasignada con el cliente correctamente.");
            }

            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void ConsultaDeAgregadosSocios(Connection conexion) {
        String consulta = "select a.idActividad, a.nombre, count(ass.idSocio) as \"sociosXActividad\" from Actividades a left join ActividadesSocios ass on a.idActividad = ass.idActividad group by a.idActividad, a.nombre";
        ResultSet rs = ejecutaQuery(conexion, consulta);

        System.out.println("\nCONSULTA SOCIOS POR ACTIVIDAD");
        System.out.println("=============");

        try {
            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);

                resultado += "; nombre: " + rs.getString(2);
                resultado += "; Número de socios: " + rs.getInt(3);

                System.out.println(resultado);
            }
            System.out.println("\nPulse una tecla para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private static void ConsultaDeAgregadosClientes(Connection conexion) {
        String consulta = "select a.idActividad, a.nombre, count(ac.idCliente) as 'clientesXActividad' from Actividades a left join ActividadesClientes ac on a.idActividad = ac.idActividad group by a.idActividad, a.nombre";
        ResultSet rs = ejecutaQuery(conexion, consulta);

        System.out.println("\nCONSULTA CLIENTES POR ACTIVIDAD");
        System.out.println("=============");

        try {
            while (rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);

                resultado += "; nombre: " + rs.getString(2);
                resultado += "; Número de clientes: " + rs.getInt(3);

                System.out.println(resultado);
            }
            System.out.println("\nPulse intro para continuar.");

            try {
                System.in.read();
            } catch (IOException ex) {
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void BorrarAgenda(Connection conexion) {
        String sql = " SELECT a.idAgenda,a.idDia,a.idActividad,a.horaInicio,a.horaFin,a.anyo, d.nombreDia, ac.nombre  FROM Agenda a  left join Dias d on a.idDia = d.idDia  left join Actividades ac on a.idActividad = ac.idActividad; ";
        String sql1 = " select idAgenda from Agenda where idAgenda = %d ";
        String sql2 = " DELETE FROM Agenda WHERE idAgenda = %d ";
        ResultSet rs ;
        int idAgenda;           
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("\nBORRAR AGENDA");
            System.out.println("=============");
            System.out.println("Listado agenda: ");
            rs = ejecutaQuery(conexion, sql);
            
            while (rs.next()) {
                String resultado = "\tIdAgenda: " + rs.getInt(1);

                resultado += "; IdDia: " + rs.getString(2) + " (" + rs.getString(7) + ")";
                resultado += "; IdActividad: " + rs.getInt(3) + " (" + rs.getString(8) + ")";
                resultado += "; horaInicio: " + rs.getTime(4);
                resultado += "; horaFin: " + rs.getTime(5);
                resultado += "; anyo: " + rs.getInt(6);

                System.out.println(resultado);
            }
            
            System.out.println("");
            System.out.println("Introduzca el IdAgenda a borrar: ");
            idAgenda = sc.nextInt();
            
            sql1 = String.format(sql1, idAgenda);
            rs = ejecutaQuery(conexion, sql1);
            
            if(!rs.next()) {
                System.out.println("El IdAgenda seleccionado, no existe.");
            } else {
                sql2 = String.format(sql2, idAgenda);
                ejecutaUpdate(conexion, sql2);
                System.out.println("El IdAgenda seleccionado se ha borrado correctamente.");
            }
            
            System.out.println("\nPulse intro para continuar.");
            try {
                System.in.read();
            } catch (IOException ex) {
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    
    private static void AgregarAgenda(Connection conexion) {
        String sql = "";
        String sql1 = " SELECT idDia,nombreDia FROM Dias; ";        
        String sql2 = " SELECT idDia,nombreDia FROM Dias WHERE idDia = %d ; ";
        String sql3 = " SELECT `idActividad`,`nombre`,`tipo` FROM `Actividades`; ";
        String sql4 = " SELECT `idActividad`,`nombre`,`tipo` FROM `Actividades` WHERE `idActividad` = %d; ";
        Scanner sc = new Scanner(System.in);
        ResultSet rs;
        int idDia, idActividad;
        int horaIni, minutoIni, horaFin, minutoFin;
        
        try {
            System.out.println("\nAGREGAR AGENDA");
            System.out.println("==============");
            System.out.println("Listado de días: ");
            rs = ejecutaQuery(conexion, sql1);
            
            while(rs.next()) {
                String resultado = "\tIdDia: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }
            
            System.out.println("");
            System.out.println("Introduzca el idDia: ");
            idDia = sc.nextInt();
            // primero buscamos si existe
            sql2 = String.format(sql2, idDia);
            rs = ejecutaQuery(conexion, sql2);

            if (!rs.next()) {
                // el día no existe
                System.out.println("El día seleccionado no existe.");
                System.out.println("\nPulse intro para continuar.");
                try {
                    System.in.read();
                } catch (IOException ex) {
                }
                return;
            } 
            
            System.out.println("Listado de actividades: ");
            rs = ejecutaQuery(conexion, sql3);
            
            while(rs.next()) {
                String resultado = "\tIdActividad: " + rs.getInt(1);
                resultado += "; Nombre: " + rs.getString(2);

                System.out.println(resultado);
            }
            
            System.out.println("");
            System.out.println("Introduzca el idActividad: ");
            idActividad = sc.nextInt();
            
            // se comprueba si existe
            sql4 = String.format(sql4, idActividad);
            rs = ejecutaQuery(conexion, sql4);
            
            if(!rs.next()) {
                // la actividad no existe
                System.out.println("La actividad seleccionada no existe.");
                System.out.println("\nPulse intro para continuar.");
                try {
                    System.in.read();
                } catch (IOException ex) {
                }
                return;
            }
            
            System.out.println("Inserte la hora de inicio de la actividad ");
            horaIni = sc.nextInt();
            System.out.println("Inserte el minuto");
            minutoIni = sc.nextInt();
            System.out.println("La hora de inicio es " + String.format("%02d", horaIni) 
                    + ":" + String.format("%02d", minutoIni));
            System.out.println("Inserte la hora en la que finaliza la actividad: ");
            horaFin = sc.nextInt();
            System.out.println("Inserte el minuto: ");
            minutoFin = sc.nextInt();
            System.out.println("La hora fin es " + String.format("%02d", horaFin) 
                    + ":" + String.format("%02d", minutoFin));
            
            if(AgregarAgendaAux(conexion, idDia, idActividad, horaIni, minutoIni, horaFin, minutoIni))
            {
                System.out.println("Se ha añadido una nueva actividad en la agenda.");
            }
            
            System.out.println("\nPulse intro para continuar.");
            try {
                System.in.read();
            } catch (IOException ex) {
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }

    private static boolean AgregarAgendaAux(Connection conexion, int idDia, int idActividad, int horaIni, int minutoIni, int horaFin, int minutoFin) {
        boolean temp = false;
        String sql = "{call agregarAgenda(?,?,?,?)}";
        
        try {
            java.sql.CallableStatement ct = conexion.prepareCall(sql);
            ct.setInt(1, idDia);
            ct.setInt(2, idActividad);
            ct.setString(3, convertDate(horaIni, minutoIni));
            ct.setString(4, convertDate(horaFin, minutoFin));            
            ct.execute();
            temp = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return temp;
    }

    private static String convertDate(int hora, int minuto) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int thora;
        int tminuto;
        String temp = "";
        
        if(hora < 0) {
            thora = 0;
        }else if (hora > 23) {
            thora = hora % 24;
        } else {
            thora = hora;
        }
        
        if(minuto < 0) {
            tminuto = 0;
        } else if (minuto > 59) {
            tminuto = minuto % 60;
        } else {
            tminuto = minuto;
        }
        
        cal.set(Calendar.HOUR_OF_DAY, thora);
        cal.set(Calendar.MINUTE, tminuto);
        cal.set(Calendar.SECOND, 0);
        temp = sdf.format(cal.getTime());
        
        return temp;
    }

    private static void Horario(Connection conexion) {
        String sql = " SELECT `nombreDia`,`horaInicio`,`horaFin`,`nombre` FROM `horario`; ";
        ResultSet rs;
        
        try {
            System.out.println("\nHORARIO");
            System.out.println("=======");
            
            rs = ejecutaQuery(conexion, sql);
            
            while(rs.next()) {
                String resultado = "\tDía: " + rs.getString(1);
                
                resultado += "; Inicio: " + rs.getTime(2);
                resultado += "; Fin: " + rs.getTime(3);
                resultado += "; Actividad: " + rs.getString(4);

                System.out.println(resultado);
            }
            
            System.out.println("\nPulse intro para continuar.");
            try {
                System.in.read();
            } catch (IOException ex) {
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }

    private static void HorarioHoy(Connection conexion) {
        String sql = " SELECT h.nombreDia,h.horaInicio,h.horaFin,h.nombre FROM horario h join Dias d on h.nombreDia = d.nombreDia where d.idDia = (dayofweek(now())-1) ";
        ResultSet rs;
        
        try {
            System.out.println("\nHORARIO DE HOY");
            System.out.println("==============");
            
            int count = mostrarHorarioHoy(conexion);
            
            if(count > 0) {
            rs = ejecutaQuery(conexion, sql);
            
                while(rs.next()) {
                    String resultado = "\tDía: " + rs.getString(1);

                    resultado += "; Inicio: " + rs.getTime(2);
                    resultado += "; Inicio: " + rs.getTime(3);
                    resultado += "; Actividad: " + rs.getString(4);

                    System.out.println(resultado);
                }
            }
            
            System.out.println("\nPulse intro para continuar.");
            try {
                System.in.read();
            } catch (IOException ex) {
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }

    private static void ActividadesXDias(Connection conexion) {
        String sql = " SELECT `nombreDia`, `ActividadesTotales` FROM `actividadesxdias`; ";
        ResultSet rs;
        
        try {
            System.out.println("\nACTIVIDADES POR DÍAS");
            System.out.println("====================");
            
            rs = ejecutaQuery(conexion, sql);
            
            while(rs.next()) {
                String resultado = "\tDía: " + rs.getString(1);

                resultado += "; Número de actividades: " + rs.getInt(2);                

                System.out.println(resultado);
            }
            
            System.out.println("\nPulse intro para continuar.");
            try {
                System.in.read();
            } catch (IOException ex) {
            }            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static int mostrarHorarioHoy(Connection conexion) {        
        int temp = 0;
        String sql = "{call horarioHoy(?)}";
        
        try {
            java.sql.CallableStatement ct = conexion.prepareCall(sql);
            ct.registerOutParameter(1, java.sql.Types.INTEGER);
            ct.execute();
            temp = ct.getInt(1);
            
            System.out.println("Hay un total de " + temp + " actividad(es) programada(s) para hoy.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return temp;
    }
}

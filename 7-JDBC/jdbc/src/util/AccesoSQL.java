package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AccesoSQL {
	
	/* ATRIBUTOS */
	private Connection con = null;
	private Statement instruccion = null;
	private ResultSet res = null;
	private String url = "jdbc:mysql://localhost/";
	/* FIN ATRIBUTOS */
	
	/* CONSTRUCTORES */
	public AccesoSQL(String bd, String usr, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("No se encuentra com.mysql.jdbc.Driver");
		} finally {
			this.url = this.url + bd;
			setConnection(usr, pass);	
		}
	}
	/* FIN CONSTRUCTORES */
	
	/* GETS */
	public Connection getConnection() {
		return this.con;
	}
	public Statement getInstruction() {
		return this.instruccion;
	}
	public ResultSet getResultSet() {
		return this.res;
	}
	public String getURL() {
		return this.url;
	}
	/* FIN GETS*/
	
	/* SETS */
	private void setConnection(String usr, String pass) {
		try {
			this.con = DriverManager.getConnection(getURL(), usr, pass);	
		} catch (SQLException e) {
			System.out.println("La base de datos no existe o no se ha iniciado el servicio");
		} finally {
			
		}
	}
	/* FIN SETS */
	
	/* METODOS*/
	public void ejecutarSQL(String sql) {
		try {
			this.instruccion = con.createStatement();
			this.res = instruccion.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Error de ejecucion de SQL, comprueba la sintaxis");
		}
	}
	public String mostrarResultSet() {
		String res = "";
		try {
			int col = getResultSet().getMetaData().getColumnCount();
			// Nombre de las columnas
			for (int i = 1; i < col+1; i++) {
				res = res + getResultSet().getMetaData().getColumnName(i) + " | ";
			}
			res = res + "\n";
			// Filas
			while (getResultSet().next()) {
				for (int i = 1; i < col+1; i++) {
					if (getResultSet().getObject(i) == null) {
						res = res + "nulo" + " | ";
					} else {
						res = res + getResultSet().getObject(i).toString() + " | ";
					}
				}
				res = res + "\n";
			}
		} catch (SQLException e) {
			
		}
		return res;
	}
	/* FIN METODOS */
}
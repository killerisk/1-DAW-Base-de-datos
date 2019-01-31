/*	Autor: Miguel Angel Castañeda Garcia
 * 	Fecha ultima revision: 31/01/2019
 */
package bol7_1;

import util.AccesoSQL;

public class Ej1 {
/*
	Para la base de datos Empresa:
	Crear un programa que muestre todos los empleados
 */
	public static void main(String[] args) {
		
		AccesoSQL sql = new AccesoSQL("empresa", "root", "1108862");
		sql.ejecutarSQL("SELECT * FROM empleados;");
		System.out.println(sql.mostrarResultSet());
		
	}
}
/*	Autor: Miguel Angel Casta�eda Garcia
 * 	Fecha ultima revision: 31/01/2019
 */
package bol7_1;

import util.AccesoSQL;

public class Ej2 {
/*
	Para la base de datos Empresa:
	Dise�ar una aplicaci�n que muestre todas las oficinas.
 */
	public static void main(String[] args) {
		
		AccesoSQL sql = new AccesoSQL("empresa", "root", "1108862");
		sql.ejecutarSQL("SELECT * FROM oficinas");
		System.out.println(sql.mostrarResultSet());
		
	}

}

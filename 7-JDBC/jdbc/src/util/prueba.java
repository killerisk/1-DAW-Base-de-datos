package util;

public class prueba {

	public static void main(String[] args) throws Exception {
		
		AccesoSQL con = new AccesoSQL("jdbc_prueba", "root", "1108862");
		
		con.ejecutarSQL("SELECT * FROM clases");
		
	}
}

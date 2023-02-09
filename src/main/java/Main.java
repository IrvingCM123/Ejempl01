import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author irvin
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        SQLDatabaseConnection object_Conexion = new SQLDatabaseConnection();
        
        object_Conexion.SQLDatabaseConnection_Establecer_Conexion();
        
        System.out.println("Leer");
        object_Conexion.SQLDatabaseConnection_Consultar_Datos();
        
        System.out.println("Insertar");
        object_Conexion.SQLDatabaseConnection_Insertar_Datos();
        
    }
}

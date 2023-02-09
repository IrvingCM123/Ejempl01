
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SQLDatabaseConnection {

    Connection conexion_Conectar = null;
    ResultSet conexion_Resultado = null;

    String conexion_Usuario = "Irving_Conde_Marin";
    String conexion_Contraseña = "IrvingConde123";
    String conexion_Base_De_Datos = "ejemplo";
    String conexion_ip = "localhost";
    String conexion_puerto = "1433";

    String conexion_configuracion = "jdbc:sqlserver://" + conexion_ip + ":" + conexion_puerto + "/" + conexion_Base_De_Datos;
    String establecer_Conexion_cadena = "jdbc:sqlserver://" + conexion_ip + ";" + "databaseName =" + conexion_Base_De_Datos + ";"
            + "encrypt=true;trustServerCertificate=true";

    public Connection SQLDatabaseConnection_Establecer_Conexion() {
        try {
            conexion_Conectar = DriverManager.getConnection(establecer_Conexion_cadena, conexion_Usuario, conexion_Contraseña);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar la base de datos, error: " + e.toString());
        }

        return conexion_Conectar;
    }

    public ResultSet SQLDatabaseConnection_Consultar_Datos() throws SQLException {
        try ( Connection conexion_Conectar = DriverManager.getConnection(establecer_Conexion_cadena, conexion_Usuario, conexion_Contraseña);  Statement statement = conexion_Conectar.createStatement();) {

            String selectSQL = "SELECT * FROM ejemplo";
            conexion_Resultado = statement.executeQuery(selectSQL);

            while (conexion_Resultado.next()) {
                System.out.println("Registro: ");
                System.out.println(conexion_Resultado.getString(1) + " " + conexion_Resultado.getString(2)
                        + " " + conexion_Resultado.getString(3) + " " + conexion_Resultado.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion_Resultado;
    }
    
    public ResultSet SQLDatabaseConnection_Insertar_Datos() throws SQLException {
        
        String insertSQL = "insert into ejemplo values ('4','Marin','Norte6','1231132314');";
        
        try ( Connection conexion_Conectar = DriverManager.getConnection(establecer_Conexion_cadena, conexion_Usuario, conexion_Contraseña);  
                PreparedStatement prepsInsertEjemplo = conexion_Conectar.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertEjemplo.execute();
            conexion_Resultado = prepsInsertEjemplo.getGeneratedKeys();

            while (conexion_Resultado.next()) {
                System.out.println("Resultado: " + conexion_Resultado.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conexion_Resultado;
    }

}

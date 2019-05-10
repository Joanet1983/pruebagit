package dominio;

import java.sql.*;

public class BBDD {

    static final String HOST = "localhost";
    static final String PORT = "3306";
    static final String DATABASE = "tienda";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String URLPARAMETERS =
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + URLPARAMETERS;

    public void conectarBBDD() {

        try {
            // Conexió del Driver Java DataBase Connector
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Felicidades! Se ha cargado el Driver MySQL");

            // Conexió a la base de dades
            Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Felicidades! Se ha conectado a la base de datos");

            // Preparar la sentencia
            Statement sentencia = connect.createStatement();

            // Executar una consulta
            //ResultSet result = sentencia.executeQuery("SELECT * FROM empleados");
            ResultSet result = sentencia.executeQuery(consultas());

            // Separador
            System.out.println("");

            // Recorrer el ResultSet (conjunt de resultats de la consulta)
            while (result.next()) {
                int codigo = result.getInt("e_codigo");
                String nombre = result.getString("e_nombre");
                String apellidos = result.getString("e_apellidos");
                String password = result.getString("e_password");

                System.out.println("----------------------------");
                System.out.printf("%d %s %s %s%n", codigo, nombre, apellidos, password);
            }

            System.out.println("----------------------------");
            System.out.println("");

            // Cerrar conexiones
            sentencia.close();
            result.close();
            connect.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error, no se ha cargado el Driver MySQL");
        } catch (SQLException ex) {
            System.out.println("Error, no se ha podido conectar a la base de datos");
        }

    }

    public String consultas() {
        String consulta = "SELECT * FROM empleados";


        return consulta;
    }



}

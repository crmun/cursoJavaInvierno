package py.una.pol.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCTest4ConsultaSimple {

	private static final Logger logger = LogManager.getLogger(JDBCTest4ConsultaSimple.class);

	public static void main(String[] args) {

		Connection conexion = null;
		try {
			Class.forName("org.postgresql.Driver");
			logger.info("Driver JDBC PostgreSQL registrado");

			conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cursojava", "postgres", "postgres");

			logger.info("Conectado a la Base de Datos");
			
			Statement statement = conexion.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM personas");
			while(resultSet.next()) {
				
				Integer id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				
				logger.debug(String.format("Id: %d, Nombre: %s, Apellido: %s", id, nombre, apellido));
			}
			resultSet.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			// TODO Eliminar dependencia JDCB maven
			logger.error("No se tiene el driver JDBC", e);
		} catch (SQLException e) {
			// TODO Enviar parámetros inválidos de conexión
			logger.error(e.getMessage(), e);
		} finally {

				try {
					
					if (conexion != null) conexion.close();		
					logger.info("Desconectado de la Base de Datos");
					
				} catch (SQLException e) {
					logger.error("Error al intentar descoctar de la Base de Datos", e);
				}

		}

	}

}

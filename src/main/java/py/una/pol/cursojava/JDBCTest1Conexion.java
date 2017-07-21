package py.una.pol.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCTest1Conexion {

	private static final Logger logger = LogManager.getLogger(JDBCTest1Conexion.class);

	public static void main(String[] args) {

		Connection conexion = null;
		try {
			Class.forName("org.postgresql.Driver");
			logger.info("Driver JDBC PostgreSQL registrado");

			conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cursojava", "postgres", "postgres");

			logger.info("Conectado a la Base de Datos");


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

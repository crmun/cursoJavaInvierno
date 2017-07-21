package py.una.pol.cursojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCTest8Transaccion {

	private static final Logger logger = LogManager.getLogger(JDBCTest8Transaccion.class);

	public static void main(String[] args) {

		Connection conexion = null;
		try {
			Class.forName("org.postgresql.Driver");
			logger.info("Driver JDBC PostgreSQL registrado");

			conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/cursojava", "postgres", "postgres");

			logger.info("Conectado a la Base de Datos");
			
			conexion.setAutoCommit(false);
			logger.debug("Comienza la transaccion");
			
			PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO personas VALUES (?, ?)");
			preparedStatement.setString(1, "Juan");
			preparedStatement.setString(2, "Perez");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		    preparedStatement = conexion.prepareStatement("INSERT INTO personas VALUES (?, ?)");
			preparedStatement.setString(1, "Jose");
			preparedStatement.setString(2, "Gomez");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			preparedStatement = conexion.prepareStatement("INSERT INTO personas VALUES (?, ?)");
			preparedStatement.setString(1, "Crispulo");
			preparedStatement.setString(2, "Gonzalez");
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			logger.debug("Se insertaron todos los registros");
			
			logger.debug("Hasta aqui no hubo errores, se procede a hacer commit");
			conexion.commit();

		} catch (ClassNotFoundException e) {
			logger.error("No se tiene el driver JDBC", e);
		} catch (Exception e) {
			logger.error("Error en insert, se ejecuta un rollback");
			logger.error(e.getMessage(), e);
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				logger.error(e.getMessage(), e);
			}
			
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

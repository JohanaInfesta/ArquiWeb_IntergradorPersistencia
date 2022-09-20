package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import clasesDAO.clienteDAO;
import clasesDAO.facturaDAO;
import clasesDAO.factura_productoDAO;
import clasesDAO.productoDAO;
import factory.CreacionDbMySQL;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {


		CreacionDbMySQL creacionDB = new CreacionDbMySQL();
		creacionDB.conecionBase();
		
		clienteDAO cDAO = new clienteDAO();
		facturaDAO fDAO = new facturaDAO();
		productoDAO pDAO = new productoDAO();
		factura_productoDAO fpDAO = new factura_productoDAO();
		cDAO.CreateTable();
		fDAO.CreateTable();
		pDAO.CreateTable();
		fpDAO.CreateTable();

		

		 cDAO.insertarListadoCSV(); 
		 pDAO.insertarListadoCSV();
		 fDAO.insertarListadoCSV(); 
		 fpDAO.insertarListadoCSV();
		

		pDAO.getProducto();
		cDAO.getClientes();
			
			
	}
}

package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import clasesDAO.clienteDAO;
import clasesDAO.facturaDAO;
import clasesDAO.factura_productoDAO;
import clasesDAO.productoDAO;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {


		clienteDAO cDAO = new clienteDAO();
//		cDAO.CreateTable();
		facturaDAO fDAO = new facturaDAO();
//		fDAO.CreateTable();
		productoDAO pDAO = new productoDAO();
//		pDAO.CreateTable();
		factura_productoDAO fpDAO = new factura_productoDAO();
//		fpDAO.CreateTable();

		

//		 cDAO.insertarListadoCSV(); 
//		 pDAO.insertarListadoCSV();
//		 fDAO.insertarListadoCSV(); 
//		 fpDAO.insertarListadoCSV();
		

		pDAO.getProducto();
		cDAO.getClientes();
			
			
	}
}

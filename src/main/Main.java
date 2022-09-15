package main;

import java.io.FileNotFoundException;
//import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import clases.Cliente;
import clases.Factura_Producto;
import clases.Facturas;
import clases.Producto;
//import clases.Facturas;
import clasesDAO.clienteDAO;
import clasesDAO.facturaDAO;
import clasesDAO.factura_productoDAO;
import clasesDAO.productoDAO;
import factory.DbMySQL;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {


		clienteDAO cDAO = new clienteDAO();
		cDAO.CreateTable();
//		facturaDAO fDAO = new facturaDAO();
//		fDAO.CreateTable();
		productoDAO pDAO = new productoDAO();
		pDAO.CreateTable();
		factura_productoDAO fpDAO = new factura_productoDAO();
		fpDAO.CreateTable();

		pDAO.getProducto();
		cDAO.getClientes();

//			@SuppressWarnings("deprecation")
//			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new
//					FileReader("./src/main/clientes.csv"));
//			for(CSVRecord row: parser) {
//				Cliente c = new Cliente (Integer.parseInt(row.get("idCliente")), row.get("nombre"), row.get("email"));
//				cDAO.Insert(c);
//			}
//			@SuppressWarnings("deprecation")
//			CSVParser parser1 = CSVFormat.DEFAULT.withHeader().parse(new
//					FileReader("./src/main/productos.csv"));
//			for(CSVRecord row: parser1) {
//				Producto p = new Producto (Integer.parseInt(row.get("idProducto")), row.get("nombre"), Integer.parseInt(row.get("valor")));
//				pDAO.Insert(p);
//			}
//			
//
//			@SuppressWarnings("deprecation")
//			CSVParser parser2 = CSVFormat.DEFAULT.withHeader().parse(new
//					FileReader("./src/main/facturas.csv"));
//			for(CSVRecord row: parser2) {
//				Facturas f = new Facturas (Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idCliente")));
//				fDAO.Insert(f);
//			}
			
//			@SuppressWarnings("deprecation")
//			CSVParser parser3 = CSVFormat.DEFAULT.withHeader().parse(new
//					FileReader("./src/main/facturas-productos.csv"));
//			for(CSVRecord row: parser3) {
//				Factura_Producto fp = new Factura_Producto (Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")), Integer.parseInt(row.get("cantidad")));
//				fpDAO.Insert(fp);
//			}
			
	}
}

package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import clases.Facturas;
import clasesDAO.clienteDAO;
import clasesDAO.facturaDAO;
import clasesDAO.factura_productoDAO;
import clasesDAO.productoDAO;


public class Main {

	public static void main(String[] args) {

		clienteDAO cDAO = new clienteDAO();
		cDAO.CreateTable();
		facturaDAO fDAO = new facturaDAO();
		fDAO.CreateTable();
//		productoDAO p = new productoDAO();
//		p.CreateTable();
//		factura_productoDAO fp = new factura_productoDAO();
//		fp.CreateTable();
		
		String csvFile = "./src/main/facturas.csv";
		String line = "";
		String cvsSplitBy = ",";

//		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//			line = br.readLine();
//			while ((line = br.readLine()) != null) {
//
//				String[] items = line.split(cvsSplitBy);
//				
//				//separo la lista es String personalizados. para tener las posiciones especificas
//
//				String idFactura = items[0];
//				String idCliente = items[1];
////				String email = items[2];
//				
//				Facturas c = new Facturas(Integer.parseInt(idFactura), Integer.parseInt(idCliente));
//				fDAO.Insert(c);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}

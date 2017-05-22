package com.hrevfdz.reports;

import com.hrevfdz.dao.StartWorkDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.models.StartWork;
import com.hrevfdz.models.StockProducto;
import com.hrevfdz.services.IPharmacy;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        findOpenWork();
    }

    private static void findOpenWork() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        IPharmacy<StartWork> daoWork = new StartWorkDAO();
        String q = "SELECT o FROM OpenWork o WHERE o.fecha = '2017-04-12' AND o.capital > 0";
        StartWork ow = null;

        try {
            ow = daoWork.findBy(q);
            if (ow == null) {
                System.err.println("Esta vacio");
            }
            System.out.println("Código: " + ow.getId());
            System.out.println("Fecha: " + sdf.format(ow.getFecha()));
            System.out.println("Capital: " + ow.getCapital());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
//            if(ow==null){
//                
//            }
            System.out.println("Model: " + ow);
        }
    }

    private static void findStock() {
        IPharmacy<StockProducto> daoS = new StockProductoDAO();

//        StockProducto sp = new StockProducto();
        try {
            String q = "SELECT t FROM StockProducto t WHERE t.codStock = 6";
            String q2 = "SELECT COUNT(s) FROM StockProducto s";
            StockProducto sp = daoS.findBy(q);
            if (sp != null) {
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Cod Stock: " + sp.getCodStock());
                System.out.println("Producto: " + sp.getNombre());
            } else {
                System.out.println("No se encontró el medicamento que busca");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

}

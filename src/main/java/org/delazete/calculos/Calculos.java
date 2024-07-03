package org.delazete.calculos;

import org.delazete.utils.TransGson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculos {
    Scanner leer = new Scanner(System.in);
    TransGson objMoneda = new TransGson();

    public double calculosMonedaPrincipal(String TipoDeCambio) throws IOException, InterruptedException {
        double moneda = (double) objMoneda.TrayendoDatos().conversion_rates().get(TipoDeCambio);
        BigDecimal bd = new BigDecimal(moneda);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Redondea a 2 decimales
        double numeroFormateado = bd.doubleValue();
        return numeroFormateado;
    }
    public double monedaDeCambio(String cambio) throws IOException, InterruptedException {
        double moneda = (double) objMoneda.TrayendoDatos().conversion_rates().get(cambio);
        BigDecimal bd = new BigDecimal(moneda);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Redondea a 2 decimales
        double numeroFormateado = bd.doubleValue();
        return moneda;
    }

    public int cuantoQuiereCambiar(){
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Ingrese la cantidad de dinero a cambiar:");
        int cantidad = leer.nextInt();
        return cantidad;
    }

}

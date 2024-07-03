package org.delazete.models;

import org.delazete.calculos.Calculos;
import org.delazete.config.Config;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner leer = new Scanner(System.in);
    Config config = new Config();

    public void mostrarMenu(){

        System.out.println("--------------------------------------------------------------------");
        System.out.println("¡Bienvenidos al convertidor de monedas!");
        System.out.println("Elija la opcion con un numero valido.");
        System.out.println("1-Peso Argentino =>> Dolar Moneda Principal: Peso Argentino");
        System.out.println("2-Dolar =>> Peso Argentino");
        System.out.println("3-Dolar =>> EURO");
        System.out.println("4-Salir");
        System.out.println("--------------------------------------------------------------------");

    }

    public int Menu() throws IOException, InterruptedException {
        Calculos calculo = new Calculos();
        System.out.print("Numero:");
        int opcion = leer.nextInt();
        switch (opcion){
            case 1:
                config.GuardarConfig("");
                config.GuardarConfig("ARS");
                double PesoArgentino = calculo.calculosMonedaPrincipal("ARS");
                double dolar = calculo.monedaDeCambio("USD");
                int cantidad = calculo.cuantoQuiereCambiar();
                double resultado = cantidad * dolar;
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Moneda=ARS  " + "\nValor= $" + PesoArgentino + " \nCantidad= $" + cantidad + " \nMoneda De cambio=USD " + "\nTasa de cambio= $" + calculo.monedaDeCambio("USD") + "\nTotal= $" + resultado + " Dolares");
                break;
            case 2:
                config.GuardarConfig("");
                config.GuardarConfig("USD");
                double Dolar = calculo.calculosMonedaPrincipal("USD");
                double Peso = calculo.monedaDeCambio("ARS");
                int cantidades = calculo.cuantoQuiereCambiar();
                double resultados = cantidades * Peso;
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Moneda= "+ config.getTipoDeMoneda() + "\nValor= $" + Dolar + " \nCantidad= $" + cantidades + " \nMoneda De cambio= ARS" + "\nTasa de cambio= $" + calculo.monedaDeCambio("ARS") + "\nTotal= $" + resultados + " Pesos");
                break;
            case 3:
                config.GuardarConfig("");
                config.GuardarConfig("USD");
                double Dolare = calculo.calculosMonedaPrincipal("USD");
                double dolares = calculo.monedaDeCambio("EUR");
                int cantidadad = calculo.cuantoQuiereCambiar();
                double resultad = cantidadad * dolares;
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Moneda=USD  " + "\nValor= $" + Dolare + " \nCantidad= $" + cantidadad + " \nMoneda De cambio=EUR " + "\nTasa de cambio= $" + calculo.monedaDeCambio("USD") + "\nTotal= $" + resultad + " Euros");
                break;
            case 4:
                break;
        }
        return opcion;
    }


}

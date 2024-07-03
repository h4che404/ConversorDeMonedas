package org.delazete;

import org.delazete.models.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            int menu1;
            do {
                do {

                    Menu menu = new Menu();
                    menu.mostrarMenu();
                    menu1 = menu.Menu();
                }while (menu1 < 0 && menu1 > 5);

            } while (menu1 != 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
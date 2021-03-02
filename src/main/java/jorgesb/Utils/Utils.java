/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgesb.Utils;

import java.util.Scanner;

/**
 *
 * @author espin
 */
public class Utils {
    public static int getInt(String texto) {
        int resultado = 0;
        boolean valid = false;
        Scanner teclado = new Scanner(System.in);
        do {
            try {
                System.out.print(texto);
                resultado = teclado.nextInt();
                valid = true;
            } catch (Exception e) {
                valid = false;
                System.out.println("\nIntroduce un numero correcto");
                teclado = new Scanner(System.in);
            }
        } while (!valid);
        return resultado;
    }
     
     public static String getString(String texto) {
        String resultado;
        Scanner teclado = new Scanner(System.in);

        System.out.print(texto);
        resultado = teclado.nextLine();

        return resultado;
    }
     
     public static void pulsarEnter() {
        System.out.print("\nPulsa Enter para continuar...");
        Scanner teclado = new Scanner(System.in);
        teclado.nextLine();
    }
}

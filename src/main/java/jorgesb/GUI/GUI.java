/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jorgesb.GUI;
import jorgesb.Utils.Utils;

import java.util.Scanner;

/**
 *
 * @author espin
 */
public class GUI {
    
    //-----------MENU PRINCIPAL----------
    public static void principal() {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Menu       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Cliente |");            
            System.out.println("| 2) Operario |");            
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero = Utils.getInt("Introduce una opción: ");
            opciones_clienteinit(numero);
        } while (numero != 0);
    }
     static void opciones_principal(int numero) {
        switch (numero) {
            case 1:
                clienteinit();
                break;
            case 2:
                operarioinit();
                break;
                
            case 0:
                
                break;

        }
    }
      //-----------FUNCIONES CLIENTE----------
      public static void clienteinit() {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Cliente       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Iniciar sesion |");            
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero =  Utils.getInt("Introduce una opción: ");
            opciones_clienteinit(numero);
        } while (numero != 0);
    }
      
      static void opciones_clienteinit(int numero) {
        switch (numero) {
            case 1:
                Iniciar_sesionC(1);
                break;
                
            case 0:
               
                break;

        }
    }
      
      
       public static void Iniciar_sesionC(int opcion) {

        boolean result = false;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        String nombre =  Utils.getString("Introduce tu nombre: ");
        String correo =  Utils.getString("Introduce tu contraseña: ");
         if (nombre.equals("") || correo.equals("")) {
            System.out.println("Usted no ha introducido nada");
             Utils.pulsarEnter();
        } else {
         clientelogueado();}
         
}
       
      
       
        public static void clientelogueado() {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Bienvenido       |");
            System.out.println("+-------------------+");
            System.out.println("| 1)Ver el saldo de la cuenta del cliente |");            
            System.out.println("| 2)Sacar dinero de la cuenta  |");            
            System.out.println("| 3)Ingresar dinero en la cuenta |");            
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero =  Utils.getInt("Introduce una opción: ");
            opciones_clientelogueado(numero);
        } while (numero != 0);
    }
      
      static void opciones_clientelogueado(int numero) {
        switch (numero) {
            case 1:
                
                break;
                
            case 0:
                
                break;

        }
    }
      
      //-----------FUNCIONES OPERARIO----------
      
      public static void operarioinit() {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Operario       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Iniciar sesion |");            
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero =  Utils.getInt("Introduce una opción: ");
            opciones_operarioinit(numero);
        } while (numero != 0);
    }
      
      static void opciones_operarioinit(int numero) {
        switch (numero) {
            case 1:
                Iniciar_sesionC(1);
                break;
                
            case 0:
                
                break;

        }
    }
       public static void Iniciar_sesionO(int opcion) {

        boolean result = false;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        String nombre =  Utils.getString("Introduce tu nombre: ");
        String correo =  Utils.getString("Introduce tu contraseña: ");
         if (nombre.equals("") || correo.equals("")) {
            System.out.println("Usted no ha introducido nada");
             Utils.pulsarEnter();
        } else {
         operariologueado();}
         
}
      
      public static void operariologueado() {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Bienvenido       |");
            System.out.println("+-------------------+");
            System.out.println("| 1)Ingresar un nuevo usuario en el banco |");            
            System.out.println("| 2)Crear una nueva cuenta bancaria  |");            
            System.out.println("| 3)Ver los datos de una cuenta bancaria |");            
            System.out.println("| 4)Ver los datos de un cliente |");            
            System.out.println("| 5)Eliminar una cuenta bancaria  |");            
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero =  Utils.getInt("Introduce una opción: ");
            opciones_clientelogueado(numero);
        } while (numero != 0);
    }
      
      static void opciones_operariologueado(int numero) {
        switch (numero) {
            case 1:
                
                break;
                
            case 0:
                
                break;

        }
    }
      
        
}


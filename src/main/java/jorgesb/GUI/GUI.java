/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgesb.GUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import jorgesb.Utils.Utils;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author espin
 */
public class GUI {

    private static DataInputStream in;
    private static DataOutputStream out;

    //-----------MENU PRINCIPAL----------
    public static void principal(Socket sc) {

        int numero;
        try {
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

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
                out.writeUTF(numero + "");
                opciones_principal(numero);
            } while (numero != 0);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void opciones_principal(int numero) throws IOException {
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

    public static void clienteinit() throws IOException {
        int numero;

        do {

            System.out.println("\n+-------------------+");
            System.out.println("|        Cliente       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Iniciar sesion |");
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero = Utils.getInt("Introduce una opción: ");
            opciones_clienteinit(numero);
        } while (numero != 0);
    }

    static void opciones_clienteinit(int numero) throws IOException {
        switch (numero) {
            case 1:
                Iniciar_sesionC(1);
                break;

            case 0:

                break;

        }
    }

    public static void Iniciar_sesionC(int opcion) throws IOException {
        Scanner teclado = new Scanner(System.in);
        boolean result = false;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        System.out.println("Introduce tu usuario: ");
        String usuario = teclado.next();
        System.out.println("Introduce tu contraseña: ");
        String contraseña = teclado.next();
        out.writeUTF(usuario);
        out.writeUTF(contraseña);
        String validate = in.readUTF();
        System.out.println(validate);
        if (validate.equals("ok")) {
            clientelogueado();
        } else {
            System.out.println(validate);
            Utils.pulsarEnter();

        }

    }

    public static void clientelogueado() throws IOException {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Bienvenido       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Ver el saldo de la cuenta del cliente |");
            System.out.println("| 2) Sacar dinero de la cuenta  |");
            System.out.println("| 3) Ingresar dinero en la cuenta |");
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero = Utils.getInt("Introduce una opción: ");
            out.writeUTF(numero + "");
            opciones_clientelogueado(numero);
        } while (numero != 0);
    }

    static void opciones_clientelogueado(int numero) throws IOException {
        Scanner teclado = new Scanner(System.in);
        switch (numero) {
            case 1:
                String r = in.readUTF();
                System.out.println(r);
                break;
            case 2:
                System.out.println("Introduzca la cantidad que desea retirar: ");
                int c = teclado.nextInt();
                out.writeUTF(c + "");
                String message = in.readUTF();
                System.out.println(message);
                break;
            case 3:
                System.out.println("Introduzca la cantidad que desea introducir: ");
                int c2 = teclado.nextInt();
                out.writeUTF(c2 + "");
                String message2 = in.readUTF();
                System.out.println(message2);
                break;

            case 0:

                break;

        }
    }

    //-----------FUNCIONES OPERARIO----------
    public static void operarioinit() throws IOException {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Operario       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Iniciar sesion |");
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero = Utils.getInt("Introduce una opción: ");
            opciones_operarioinit(numero);
        } while (numero != 0);
    }

    static void opciones_operarioinit(int numero) throws IOException {
        switch (numero) {
            case 1:
                Iniciar_sesionC(1);
                break;

            case 0:

                break;

        }
    }

    public static void Iniciar_sesionO(int opcion) throws IOException {

        boolean result = false;

        System.out.println("\n+-------------------+");
        System.out.println("|   Iniciar Sesion  |");
        System.out.println("+-------------------+");
        String nombre = Utils.getString("Introduce tu nombre: ");
        String correo = Utils.getString("Introduce tu contraseña: ");
        if (nombre.equals("") || correo.equals("")) {
            System.out.println("Usted no ha introducido nada");
            Utils.pulsarEnter();
        } else {
            operariologueado();
        }

    }

    public static void operariologueado() throws IOException {
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

            numero = Utils.getInt("Introduce una opción: ");
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

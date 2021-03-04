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
            System.out.println("|      Operario       |");
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
            operariologueado();
        } else {
            System.out.println(validate);
            Utils.pulsarEnter();

        }

    }

    public static void operariologueado() throws IOException {
        int numero;

        do {
            Scanner teclado = new Scanner(System.in);
            System.out.println("\n+-------------------+");
            System.out.println("|        Bienvenido       |");
            System.out.println("+-------------------+");
            System.out.println("| 1) Ingresar un nuevo usuario en el banco |");
            System.out.println("| 2) Crear una nueva cuenta bancaria  |");
            System.out.println("| 3) Ver los datos de una cuenta bancaria |");
            System.out.println("| 4) Ver los datos de un cliente |");
            System.out.println("| 5) Eliminar una cuenta bancaria  |");
            System.out.println("| 0) Salir          |");
            System.out.println("+-------------------+");

            numero = Utils.getInt("Introduce una opción: ");
            out.writeUTF(numero + "");
            opciones_operariologueado(numero);
        } while (numero != 0);
    }

    static void opciones_operariologueado(int numero) throws IOException {
        Scanner teclado = new Scanner(System.in);
        switch (numero) {
            case 1:
                System.out.println("Introduzca su DNI: ");
                String dni=teclado.next();
                out.writeUTF(dni);
                System.out.println("Introduzca su Nombre: ");
                String Nombre=teclado.next();
                out.writeUTF(Nombre);
                System.out.println("Introduzca sus Apellidos: ");
                String apellidos=teclado.next();
                out.writeUTF(apellidos);
                System.out.println("Introduzca su Fecha de nacimiento: ");
                String fnacimiento=teclado.next();
                out.writeUTF(fnacimiento);
                System.out.println("Introduzca su Telefono: ");
                String tlf=teclado.next();
                out.writeUTF(tlf);
                System.out.println("Introduzca su Email: ");
                String email=teclado.next();
                out.writeUTF(email);
                System.out.println("Introduzca su Login: ");
                String login=teclado.next();
                out.writeUTF(login);
                System.out.println("Introduzca su contraseña: ");
                String pass=teclado.next();
                out.writeUTF(pass);
                
                String message=in.readUTF();
                System.out.println(message);

                break;
            case 2:
                
                String clientes=in.readUTF();
                System.out.println(clientes);
                System.out.println("Introduzca el ID del cliente al que desea asociar la cuenta: ");
                String client=teclado.next();
                out.writeUTF(client);
                System.out.println("Introduzca el saldo de la cuenta: ");
                String saldo=teclado.next();
                out.writeUTF(saldo);
                String message2=in.readUTF();
                System.out.println(message2);
                break;
            case 3:
                String cuentas=in.readUTF();
                System.out.println(cuentas);
                System.out.println("Introduzca el ID de la cuenta que desea ver: ");
                String idcuenta=teclado.next();
                out.writeUTF(idcuenta);
                
                String message3=in.readUTF();
                System.out.println(message3);

                break;
            case 4:
                String clientes2=in.readUTF();
                System.out.println(clientes2);
                System.out.println("Introduzca el ID del cliente que desea ver: ");
                String idclient=teclado.next();
                out.writeUTF(idclient);
                
                String message4=in.readUTF();
                System.out.println(message4);

                break;
            case 5:                
                String cuentas2=in.readUTF();
                System.out.println(cuentas2);
                System.out.println("Introduzca el ID de la cuenta que desea eliminar: ");
                String idcuenta2=teclado.next();
                out.writeUTF(idcuenta2);
                
                String message5=in.readUTF();
                System.out.println(message5);
                

                break;

            case 0:

                break;

        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgesb.App;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorgesb.Utils.Utils;

/**
 *
 * @author Alberto343
 */
public class app {

    public static void main(String[] args) {
        //Host del servidor
        final String HOST = "172.16.16.157";
        //Puerto del servidor
        final int PUERTO = 10578;
        DataInputStream in;
        DataOutputStream out;

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            String nombre = Utils.getString("Introduce tu login: ");
            String correo = Utils.getString("Introduce tu contraseña: ");

            //Envio un mensaje al cliente
            out.writeUTF(nombre);
            out.writeUTF(correo);

            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();

            System.out.println(mensaje);

            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

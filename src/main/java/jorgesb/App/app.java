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
import jorgesb.GUI.GUI;
import jorgesb.Utils.Utils;

/**
 *
 * @author Alberto343
 */
public class app {

    public static void main(String[] args) {
        //Host del servidor
        final String HOST = "192.168.100.4";
        //Puerto del servidor
        final int PUERTO = 10578;
        

        try {
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket(HOST, PUERTO);

           
            GUI.principal(sc);

            

            

           

            

        } catch (IOException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

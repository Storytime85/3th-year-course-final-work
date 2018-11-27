package server.entities;

import connectors.LoginDataBaseConnector;
import entities.UsersEntity;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Login {
    private LoginDataBaseConnector connection;
    private Socket client;

    public Login (LoginDataBaseConnector connection, Socket client){
        this.connection = connection;
        this.client = client;
        run();
    }

    private void run (){
        try {
            DataInputStream input = new DataInputStream(client.getInputStream());

            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            DataOutputStream connected = new DataOutputStream(client.getOutputStream());

            String loginEntry = input.readUTF();
            String passwordEntry = input.readUTF();
            boolean isConnected = connection.connect(loginEntry, passwordEntry);

            connected.writeBoolean(isConnected);
            connected.flush();
            if (isConnected){
                UsersEntity person = connection.getPersonData();
                output.writeObject(person);
                output.flush();
            }
            client.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package server.entities;

import connectors.LoginDataBaseConnector;
import entities.UsersEntity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Registration {
    private LoginDataBaseConnector connection;
    private Socket client;

    public Registration(LoginDataBaseConnector connection, Socket client){
        this.connection = connection;
        this.client = client;
        run();
    }

    private void run(){
        try {
            ObjectInputStream newUser = new ObjectInputStream(client.getInputStream());
            DataOutputStream connected = new DataOutputStream(client.getOutputStream());

            UsersEntity person = (UsersEntity) newUser.readObject();
            boolean temp = connection.registration(person);
            connected.writeBoolean(temp);
            connected.flush();

            client.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Ты не тот объект отправил, дебил");
        }
    }
}

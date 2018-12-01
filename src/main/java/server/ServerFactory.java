package server;

import connectors.LoginDataBaseConnector;
import connectors.MainDataBaseConnector;
import server.entities.DataBase;
import server.entities.Login;
import server.entities.Registration;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFactory {
    public static void main(String[] args) {
        try {
            LoginDataBaseConnector ubConnection = new LoginDataBaseConnector();
            MainDataBaseConnector dbConnection = new MainDataBaseConnector();
            String incomingCommand;
            ServerSocket server = new ServerSocket(3345);
            while (!server.isClosed()) {
                try {
                    Socket client = server.accept();
                    //проверка работоспособности сервера
                    System.out.print("Connection accepted.\n");

                    DataInputStream command = new DataInputStream(client.getInputStream());
                    incomingCommand = command.readUTF();
                    switch (incomingCommand) {
                        case "login": {
                            Login login = new Login(ubConnection, client);
                            client.close();
                            break;
                        }
                        case "registration": {
                            Registration registration = new Registration(ubConnection, client);
                            client.close();
                            break;
                        }
                        case "database":{
                            DataBase dataBase = new DataBase(dbConnection, client);
                            dbConnection.updateConnection();
                            client.close();
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Неверная команда");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

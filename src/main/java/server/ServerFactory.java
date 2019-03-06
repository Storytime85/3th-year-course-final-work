package server;

import connectors.LoginDataBaseConnector;
import connectors.MainDataBaseConnector;
import server.entities.DataBase;
import server.entities.Login;
import server.entities.Registration;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ServerFactory implements Runnable {

    protected Socket clientSocket = null;
    private LoginDataBaseConnector ubConnection;
    private MainDataBaseConnector dbConnection;

    public ServerFactory(Socket clientSocket, LoginDataBaseConnector ubConnection, MainDataBaseConnector dbConnection) {
        this.clientSocket = clientSocket;
        this.ubConnection = ubConnection;
        this.dbConnection = dbConnection;
    }

    @Override
    public void run() {
        String incomingCommand;
        try {
            System.out.print("Connection accepted.\n");

            DataInputStream command = new DataInputStream(clientSocket.getInputStream());
            incomingCommand = command.readUTF();
            switch (incomingCommand) {
                case "login": {
                    Login login = new Login(ubConnection, clientSocket);
                    break;
                }
                case "registration": {
                    Registration registration = new Registration(ubConnection, clientSocket);
                    break;
                }
                case "database":{
                    DataBase dataBase = new DataBase(dbConnection, clientSocket);
                    dbConnection.updateConnection();
                    break;
                }
                case "report":{

                }
                default: {
                    throw new IllegalArgumentException("Неверная команда");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
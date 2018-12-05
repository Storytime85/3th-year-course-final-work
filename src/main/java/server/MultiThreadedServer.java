package server;

import connectors.LoginDataBaseConnector;
import connectors.MainDataBaseConnector;

import java.net.ServerSocket;

import java.net.Socket;
import java.io.IOException;

public class MultiThreadedServer implements Runnable{

    private int serverPort;
    private ServerSocket serverSocket;
    private LoginDataBaseConnector ubConnection;
    private MainDataBaseConnector dbConnection;

    public MultiThreadedServer(int port, LoginDataBaseConnector ubConnection, MainDataBaseConnector dbConnection){
        this.serverPort = port;
        this.dbConnection = dbConnection;
        this.ubConnection = ubConnection;
    }

    @Override
    public void run(){
        openServerSocket();
        while(true){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException("Error accepting client connection", e);
            }
            new Thread(new ServerFactory(clientSocket, ubConnection, dbConnection)).start();
        }
    }

    private void openServerSocket() {
        System.out.println("Opening server socket...");
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port " + this.serverPort, e);
        }
    }

}
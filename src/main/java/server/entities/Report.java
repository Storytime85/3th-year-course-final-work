package server.entities;

import connectors.MainDataBaseConnector;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Report {
    private MainDataBaseConnector connection;
    private Socket client;

    public Report(MainDataBaseConnector connection, Socket client){
        this.connection = connection;
        this.client = client;
        run();
    }

    private void run(){
        try{
            DataInputStream string = new DataInputStream(client.getInputStream());

            String command  = string.readUTF();
            String secondCommand = string.readUTF();

            switch (command){

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

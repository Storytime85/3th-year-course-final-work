package server;

import connectors.LoginDataBaseConnector;
import connectors.MainDataBaseConnector;
import server.entities.DataBase;
import server.entities.Login;
import server.entities.Registration;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerFactory {
    public static void main(String[] args) {
        /*try {
            Selector selector = Selector.open();

            ServerSocketChannel socket = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("localhost", 3345);

            socket.bind(address);
            socket.configureBlocking(false);

            int ops = socket.validOps();
            SelectionKey selectKey = socket.register(selector, ops, null);
            System.out.println("Server is up");

            while(true){
                // Selects a set of keys whose corresponding channels are ready for I/O operations
                selector.select();

                // token representing the registration of a SelectableChannel with a Selector
                Set<SelectionKey> crunchifyKeys = selector.selectedKeys();
                Iterator<SelectionKey> crunchifyIterator = crunchifyKeys.iterator();

                while (crunchifyIterator.hasNext()) {
                    SelectionKey myKey = crunchifyIterator.next();

                    // Tests whether this key's channel is ready to accept a new socket connection
                    if (myKey.isAcceptable()) {
                        SocketChannel crunchifyClient = crunchifySocket.accept();

                        // Adjusts this channel's blocking mode to false
                        crunchifyClient.configureBlocking(false);

                        // Operation-set bit for read operations
                        crunchifyClient.register(selector, SelectionKey.OP_READ);

                        // Tests whether this key's channel is ready for reading
                    } else if (myKey.isReadable()) {

                        SocketChannel crunchifyClient = (SocketChannel) myKey.channel();
                        ByteBuffer crunchifyBuffer = ByteBuffer.allocate(256);
                        crunchifyClient.read(crunchifyBuffer);
                        String result = new String(crunchifyBuffer.array()).trim();

                        log("Message received: " + result);

                        if (result.equals("Crunchify")) {
                            crunchifyClient.close();
                            log("\nIt's time to close connection as we got last company name 'Crunchify'");
                            log("\nServer will keep running. Try running client again to establish new connection");
                        }
                    }
                    crunchifyIterator.remove();
                }

            }

        } catch (IOException e){
            e.printStackTrace();
        }*/

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

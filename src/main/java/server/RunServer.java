package server;

import connectors.LoginDataBaseConnector;
import connectors.MainDataBaseConnector;

public class RunServer {
    private static final int PORT_WORK = 3345;
    private static final int PORT_STOP = 3346;

    public static void main(String[] args) {
        LoginDataBaseConnector ubConnection = new LoginDataBaseConnector();
        MainDataBaseConnector dbConnection = new MainDataBaseConnector();
        MultiThreadedServer server = new MultiThreadedServer(PORT_WORK, ubConnection, dbConnection );

        new Thread(server).start();
        try {
            Thread monitor = new StopMonitor(PORT_STOP);
            monitor.start();
            monitor.join();
            System.out.println("Right after join.....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
    }
}

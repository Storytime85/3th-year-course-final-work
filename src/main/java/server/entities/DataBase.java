package server.entities;

import connectors.MainDataBaseConnector;
import entities.db.*;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class DataBase {
    private MainDataBaseConnector connection;
    private Socket client;

    public DataBase(MainDataBaseConnector connection, Socket client){
        this.connection = connection;
        this.client = client;
        run();
    }

    private void run(){
        try{
            // Варианты команд:
            // getAll - Получить все данные
            // get... - Получить данные конкретной таблицы
            // set... - Добавить данные в конкретную таблицу ???
            // delete... - удалить запись
            // update... - обновить запись
            //
            DataInputStream string = new DataInputStream(client.getInputStream());

            String command  = string.readUTF();

            switch (command){
                //region GETs
                case "getAll": {
                    getAll(client, connection);
                    break;
                }
                case "getFlats": {
                    getFlats(client, connection);
                    break;
                }
                case "getBuildings": {
                    getBuildings(client, connection);
                    break;
                }
                case "getSalaries": {
                    getSalaries(client, connection);
                    break;
                }
                case "getMigrators": {
                    getMigrators(client, connection);
                    break;
                }
                case "getHouseholds": {
                    getHouseholds(client, connection);
                    break;
                }
                case "getHumans": {
                    getHumans(client, connection);
                    break;
                }
                //endregion

                //region SETs
                case "setNewBuilding":{
                    setNewBuilding(client, connection);
                    break;
                }
                case "setNewFlat":{
                    setNewFlat(client, connection);
                    break;
                }
                case "setNewHousehold":{
                    setNewHousehold(client, connection);
                    break;
                }
                case "setNewHuman":{
                    setNewHuman(client, connection);
                    break;
                }
                case "setNewMigration":{
                    setNewMigration(client, connection);
                    break;
                }
                case "setNewSalary":{
                    setNewSalary(client, connection);
                    break;
                }
                //endregion

                //region DELETEs
                case "deleteBuilding":{
                    deleteBuilding(client, connection);
                    break;
                }
                case "deleteFlat":{
                    deleteFlat(client, connection);
                    break;
                }
                case "deleteHousehold":{
                    deleteHousehold(client, connection);
                    break;
                }
                case "deleteHuman":{
                    deleteHuman(client, connection);
                    break;
                }
                case "deleteMigration":{
                    deleteMigration(client, connection);
                    break;
                }
                case "deleteSalary":{
                    deleteSalary(client, connection);
                    break;
                }
                //endregion

                default: {
                    throw new IllegalArgumentException("Ошибка: получена неверная строка") ;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения:" + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Передан неверный объект:" + e);
        }
    }

    //region get
    private void getAll(Socket client, MainDataBaseConnector connection) throws IOException{
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());

        output.writeObject(connection.getBuildings());
        output.flush();
        output.writeObject(connection.getFlats());
        output.flush();
        output.writeObject(connection.getHouseholds());
        output.flush();
        output.writeObject(connection.getHumans());
        output.flush();
        output.writeObject(connection.getMigrations());
        output.flush();
        output.writeObject(connection.getSalaries());
        output.flush();

        output.close();
    }

    private void getHumans(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getHumans());
        output.flush();
        output.close();
    }

    private void getBuildings(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getBuildings());
        output.flush();
        output.close();
    }

    private void getFlats(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getFlats());
        output.flush();
        output.close();
    }

    private void getSalaries(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getSalaries());
        output.flush();
        output.close();
    }

    private void getMigrators(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getMigrations());
        output.flush();
        output.close();
    }

    private void getHouseholds(Socket client, MainDataBaseConnector connection) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        output.writeObject(connection.getHouseholds());
        output.flush();
        output.close();
    }
    //endregion

    //region set
    private void setNewHuman (Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.addNew((dbHumantableEntity)input.readObject());
        input.close();
    }

    private void setNewBuilding(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.addNew((dbBuildingtableEntity)input.readObject());
        input.close();
    }

    private void setNewFlat(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.addNew((dbFlattableEntity)input.readObject());
        input.close();
    }

    @SuppressWarnings("unchecked")
    private void setNewHousehold(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.addNew((List<dbHouseholdtableEntity>) input.readObject());
        input.close();
    }

    private void setNewMigration(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.addNew((dbMigrationtableEntity) input.readObject());
        input.close();
    }

    private void setNewSalary(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException{
        DataOutputStream ID = new DataOutputStream(client.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());

        connection.addNew((dbSalariestableEntity) input.readObject());

        ID.writeInt(connection.getLastSalary());
        ID.flush();

        ID.close();
        input.close();
    }
    //endregion

    //region delete
    private void deleteBuilding(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbBuildingtableEntity)input.readObject());
        input.close();
    }

    private void deleteFlat(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbFlattableEntity)input.readObject());
        input.close();
    }

    private void deleteHousehold(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbHouseholdtableEntity)input.readObject());
        input.close();
    }

    private void deleteHuman(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbHumantableEntity)input.readObject());
        input.close();
    }

    private void deleteMigration(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbMigrationtableEntity)input.readObject());
        input.close();
    }

    private void deleteSalary(Socket client, MainDataBaseConnector connection)
            throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
        connection.delete((dbSalariestableEntity)input.readObject());
        input.close();
    }
    //endregion
}

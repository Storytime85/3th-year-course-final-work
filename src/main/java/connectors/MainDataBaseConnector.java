package connectors;

import entities.db.*;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import persistence.DataBaseUtil;

import java.util.List;

public class MainDataBaseConnector {
    private Session session = DataBaseUtil.getSessionFactory().openSession();

    private List buildings;
    private List flats;
    private List households;
    private List humans;
    private List migrations;
    private List salaries;

    public MainDataBaseConnector() {
        updateConnection();
    }
    @SuppressWarnings("unchecked")
    public void updateConnection(){
        Query query = session.createQuery("from dbBuildingtableEntity");
        buildings = query.list();

        query = session.createQuery("from dbFlattableEntity ");
        flats = query.list();

        query = session.createQuery("from dbHouseholdtableEntity ");
        households = query.list();

        query = session.createQuery("from dbSalariestableEntity ");
        salaries = query.list();

        query = session.createQuery("from dbMigrationtableEntity ");
        migrations = query.list();

        query = session.createQuery("from dbHumantableEntity ");
        humans = query.list();
    }

    //region getters
    public List getBuildings() {
        return buildings;
    }

    public List getFlats() {
        return flats;
    }

    public List getHouseholds() {
        return households;
    }

    public List getHumans() {
        return humans;
    }

    public List getMigrations() {
        return migrations;
    }

    public List getSalaries() {
        return salaries;
    }

    public int getLastSalary(){
        dbSalariestableEntity temp = (dbSalariestableEntity) salaries.get(salaries.size()-1);
        return temp.getSalaryId();
    }
    //endregion

    //region addNew
    public void addNew(dbBuildingtableEntity newBuilding) {
        try {
            session.beginTransaction();
            session.save(newBuilding);
            session.getTransaction().commit();

            System.out.println("Здание успешно добавлено");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");

        }
        updateConnection();
    }

    public void addNew(dbFlattableEntity newFlat) {
        try {
            session.beginTransaction();
            session.save(newFlat);
            session.getTransaction().commit();

            System.out.println("Квартира успешно добавлена");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");
        }
        updateConnection();
    }

    public void addNew(List<dbHouseholdtableEntity> newHousehold) {
        try {
            for (dbHouseholdtableEntity h : newHousehold) {
                session.beginTransaction();
                session.save(h);
                session.getTransaction().commit();
            }
            System.out.println("Домохозяйство успешно добавлено");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");
        }
        updateConnection();
    }

    public void addNew(dbHumantableEntity newHuman) {
        try {
            session.beginTransaction();
            session.save(newHuman);
            session.getTransaction().commit();

            System.out.println("Человек успешно добавлен");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");

        }
        updateConnection();
    }

    public void addNew(dbMigrationtableEntity newMigration) {
        try {
            session.beginTransaction();
            session.save(newMigration);
            session.getTransaction().commit();

            System.out.println("Мигрант успешно добавлен.");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");

        }
        updateConnection();
    }

    public void addNew(dbSalariestableEntity newSalaries) {
        try {
            session.beginTransaction();
            session.save(newSalaries);
            session.getTransaction().commit();

            System.out.println("Запись о доходах успешно добавлена");
        } catch (NonUniqueObjectException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            System.out.println("Данная запись уже существует.");

        }
        updateConnection();
    }
    //endregion

    //region delete
    public void delete(dbBuildingtableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }

    public void delete(dbFlattableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }

    public void delete(dbHouseholdtableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }

    public void delete(dbHumantableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }

    public void delete(dbMigrationtableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }

    public void delete(dbSalariestableEntity object){
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        updateConnection();
    }
    //endregion

    //Todo: апдейты/сейвоапдейты

    public void saveOrUpdate(Object object) {
        session.beginTransaction();
        session.saveOrUpdate(object);
        updateConnection();
    }

    public void update(Object object){
        session.beginTransaction();
        session.update(object);
        updateConnection();
    }

}

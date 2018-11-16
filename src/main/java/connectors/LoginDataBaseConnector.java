package connectors;

import entities.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import persistence.LoginUtil;

import java.util.*;

public class LoginDataBaseConnector {
    private List persons;
    private Session session = LoginUtil.getSessionFactory().openSession();

    public boolean connect(String UserLogin, String UserPassword){

        //SELECT * FROM userbase.users u WHERE u.UserEmail="UserLogin" AND u.UserPassword="UserPassword";
        Query qry = session.createQuery("from UsersEntity u where u.userEmail=\'"+ UserLogin +
                "\' and u.password=\'" + UserPassword + "\'");
        persons =qry.list();

        switch (persons.size()){
            case 1:{
                return true;
            }
            default:{
                return false;
            }
        }
    }

    public boolean registration(UsersEntity newUser){
        try {
            session.beginTransaction();

            session.save(newUser);
            session.getTransaction().commit();

            System.out.println("Пользователь успешно добавлен");
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    public UsersEntity getPerson(){
        return (UsersEntity) persons.get(0);
    }

    public UsersEntity getPersonData(){
        UsersEntity result = new UsersEntity();
        result.copy((UsersEntity)persons.get(0));
        result.setUserEmail(null);
        result.setPassword(null);
        return result;
    }
}

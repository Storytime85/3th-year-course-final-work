package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "userbase", catalog = "")
public class UsersEntity implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    //region Fields
    private int id;
    private String userEmail;
    private String password;
    private String userName;
    private String userLastname;
    private String userPatrenimic;
    private int permissions;
    private Integer serial;
    private Integer passport;
    private Integer code;
    //endregion

    //region Constructors
    public UsersEntity(String newName, String newLastname, int newRights){
        userName = newName;
        userLastname = newLastname;
        permissions = newRights;
    }

    public UsersEntity(){

    }
    //endregion

    //region GETTERs and SETTERs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "UserEmail", nullable = false, length = 20)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "UserPassword", nullable = false, length = 15)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "UserName", nullable = true, length = 15)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "UserLastname", nullable = true, length = 15)
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Basic
    @Column(name = "UserPatrenimic", nullable = false, length = 15)
    public String getUserPatrenimic() {
        return userPatrenimic;
    }

    public void setUserPatrenimic(String userPatrenimic) {
        this.userPatrenimic = userPatrenimic;
    }

    @Basic
    @Column(name = "Permissions")
    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    @Basic
    @Column(name = "Serial", nullable = true)
    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "Passport", nullable = true)
    public Integer getPassport() {
        return passport;
    }

    public void setPassport(Integer passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "Code", nullable = true)
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                permissions == that.permissions &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(password, that.password) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userLastname, that.userLastname) &&
                Objects.equals(userPatrenimic, that.userPatrenimic) &&
                Objects.equals(serial, that.serial) &&
                Objects.equals(passport, that.passport) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userEmail, password, userName, userLastname, userPatrenimic, permissions, serial, passport, code);
    }

    public void copy(UsersEntity another) {
        this.id = another.id;
        this.userEmail = another.userEmail;
        this.password = another.password;
        this.userName = another.userName;
        this.userLastname = another.userLastname;
        this.userPatrenimic = another.userPatrenimic;
        this.permissions = another.permissions;
        this.serial = another.serial;
        this.passport = another.passport;
        this.code = another.code;
    }
}

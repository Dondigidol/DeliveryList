package dbServices.dataSets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private long userId;
    @Column(name = "name")
    private String userName;
    @Column(name = "surname")
    private String userSurname;
    @Column(name = "position")
    private String userPosition;

    public User(){

    }

    public User(long userId, String userName, String userSurname, String userPosition){
        this.setUserId(userId);
        this.setUserName(userName);
        this.setUserSurname(userSurname);
        this.setUserPosition(userPosition);
    }



    public void setUserId(long userId){
        this.userId = userId;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserSurname(String userSurname){
        this.userSurname = userSurname;
    }

    public void setUserPosition(String userPosition){
        this.userPosition = userPosition;
    }

    public long getUserId(){
        return userId;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserSurname(){
        return userSurname;
    }

    public String getUserPosition(){
        return userPosition;
    }

    @Override
    public String toString(){
        return "User{" +
                "id = " + userId +
                ", name = "+ userName +
                ", surname = " + userSurname +
                ", position = " + userPosition +
                "}";
    }






}

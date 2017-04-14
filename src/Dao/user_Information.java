package Dao;

/**
 * Created by 17853 on 2017/4/14.
 * create a type of user
 */
public class user_Information {
    public String email;
    public String name;
    public String password;
    public String toString(){
        String user = email+","+name+","+password;
        return user;
    }
}

package Dao;

/**
 * Created by 17853 on 2017/4/14.
 * username and book list
 */
public class pageUser_Information {
    public String name;
    public String email;
    public int sign;
    public String toString(){
        String pageUser = name+","+sign;
        return pageUser;
    }
}

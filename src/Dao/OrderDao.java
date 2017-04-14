package Dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by 17853 on 2017/4/14.
 * Save order information.
 */
public class OrderDao {
    public static void OrderAdd(Order_Information order){
        Connection con = DBUtil.getCon();
        String sql = "insert into `order` (name,address,zipCode,telephone,mobilePhone) values(?,?,?,?,?)";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1,order.name);
            prep.setString(2,order.address);
            prep.setString(3,order.zipCode);
            prep.setString(4,order.telephone);
            prep.setString(5,order.mobilePhone);
            prep.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

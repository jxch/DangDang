package Dao;

/**
 * Created by 17853 on 2017/4/14.
 * create a type of order.
 */
public class Order_Information {
    public String name;
    public String address;
    public String zipCode;
    public String telephone;
    public String mobilePhone;
    public String toString(){
        String Order = name+","+address+","+zipCode+","+telephone+","+mobilePhone;
        return Order;
    }
}

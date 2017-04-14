package Dao;

import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by 17853 on 2017/4/13.
 * List all books
 */
public class BookDao {
    public static ArrayList<book_Information> bookList(){
        ArrayList<book_Information> books = new ArrayList<book_Information>();
        Connection con = DBUtil.getCon();
            String sql = "select * from book";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                book_Information book = new book_Information();
                book.id = rs.getInt("id");
                book.name = rs.getString("name");
                book.price = rs.getFloat("price");
                book.price_dangDang = rs.getFloat("price_dangDang");
                book.fraction = rs.getInt("fraction");
                book.author = rs.getString("author");
                book.press = rs.getString("press");
                book.publication_date = rs.getString("publication_date");
                book.introduction = rs.getString("introduction");
                book.image_Path = rs.getString("image_Path");
                books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }
    public static void bookAddToShoppingCart(int id){
        Connection con = DBUtil.getCon();
        String name = getUsername();
        if (IsNull(id) == 0) {
            String sql = "insert into shoppingcart(userName,book_Id,number) values(?,?,?)";
            try {
                PreparedStatement prep = con.prepareStatement(sql);
                prep.setString(1, name);
                prep.setInt(2, id);
                prep.setInt(3, 1);
                prep.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            String sql = "update shoppingcart set number=? where book_Id="+id+" and userName="+"'"+name+"'";
            try {
                PreparedStatement prep = con.prepareStatement(sql);
                int num = bookNum(id) + 1;
                prep.setInt(1,num);
                prep.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static int bookNum(int id){
        int num = 0;
        Connection con = DBUtil.getCon();
        String sql ="select number from shoppingcart where book_Id="+id;
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                num = rs.getInt("number");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return num;
    }
    public static int IsNull(int id){
        Connection con = DBUtil.getCon();
        String sql = "select userName from shoppingcart where book_Id="+id;
        String name = null;
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                name = rs.getString("userName");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (name == null){
            return 0;
        }
        return 1;
    }
    public static void delBook_shoppingCart(int id){
        Connection con = DBUtil.getCon();
        String sql = "delete from shoppingcart where book_Id=?";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1,id);
            prep.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<book_Information> shoppingCart(String username){
        ArrayList<book_Information> books = new ArrayList<book_Information>();
        Connection con = DBUtil.getCon();
        String sql = "select * from shoppingcart WHERE userName="+"'"+username+"'";
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){
                book_Information book = new book_Information();
                int book_Id;
                book_Id = rs.getInt("book_Id");
                book = bookId(book_Id);
                books.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return books;
    }
    public static book_Information bookId(int id){
        book_Information book = new book_Information();
        Connection con = DBUtil.getCon();
        String sql = "select * from book where id="+id;
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                book.id = rs.getInt("id");
                book.name = rs.getString("name");
                book.price = rs.getFloat("price");
                book.price_dangDang = rs.getFloat("price_dangDang");
                book.fraction = rs.getInt("fraction");
                book.author = rs.getString("author");
                book.press = rs.getString("press");
                book.publication_date = rs.getString("publication_date");
                book.introduction = rs.getString("introduction");
                book.image_Path = rs.getString("image_Path");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return book;
    }
    public static String getUsername(){
        String name = "jxc";

        return name;
    }
}

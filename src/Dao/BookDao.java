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
}

package Dao;

/**
 * Created by 17853 on 2017/4/13.
 * create a Types of book
 */
public class book_Information {
    public int   id;                    //数据库 id号
    public String name;                 //书名
    public float price;                //价格
    public float price_dangDang;      //当当价
    public int   fraction;            //顾客评分
    public String author;              //作者
    public String press;               //出版社
    public String publication_date;   //出版日期
    public String introduction;       //书籍简介
    public String image_Path;         //封面图片路径

    public String toString(){
        String book = id+","+name+","+price+","+fraction+","+author+","+press+","+publication_date+","+introduction+","+image_Path;
        return book;
    }
}

package service;

import Dao.BookDao;
import Dao.book_Information;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 17853 on 2017/4/13.
 * List the sopping cart
 */
public class shoppingCartList extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = BookDao.getUsername();
        ArrayList<book_Information> books = BookDao.shoppingCart(name);
        req.setAttribute("shoppingCart",books);
        req.getRequestDispatcher("cart.jsp").forward(req,resp);
    }
}
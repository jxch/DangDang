package service;

import Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/13.
 * delete book from shopping cart
 */
public class delBook_ShoppingCart extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BookDao.delBook_shoppingCart(Integer.parseInt(id));
        resp.sendRedirect("shoppingCart");
    }
}

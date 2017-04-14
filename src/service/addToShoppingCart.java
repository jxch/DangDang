package service;

import Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/13.
 * Add the book to the shopping cart
 */
public class addToShoppingCart extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        int bookId = Integer.parseInt(id);
        BookDao.bookAddToShoppingCart(bookId);
        resp.sendRedirect("shoppingCart");
    }
}

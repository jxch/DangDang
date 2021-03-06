package service;

import Dao.book_Information;
import Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 17853 on 2017/4/13.
 * Show the data
 */
public class bookListServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<book_Information> books = BookDao.bookList();
        req.setAttribute("books",books);
        req.getRequestDispatcher("bookList.jsp").forward(req,resp);
    }
}

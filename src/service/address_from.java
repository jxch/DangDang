package service;

import Dao.OrderDao;
import Dao.Order_Information;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/14.
 * order
 */
public class address_from extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sign = 0;
        req.setAttribute("sign",sign);
        req.getRequestDispatcher("address_form.jsp").forward(req,resp);
    }
}

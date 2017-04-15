package service;

import Dao.pageUser_Information;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/14.
 * login.jsp
 */
public class login_jsp extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pageUser_Information sign = new pageUser_Information();
        sign.name = null;
        sign.email = null;
        sign.sign = 3;
        req.setAttribute("sign",sign);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}

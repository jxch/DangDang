package service;

import Dao.user_Information;
import Dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/14.
 * login
 */
public class login extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        user_Information user = new user_Information();
        user.email = email;
        user.password = password;
        int l = userDao.login(user);
        if (l == 1){
            req.getRequestDispatcher("login.html").forward(req,resp);
        }else if (l == 2){
            req.getRequestDispatcher("register.html").forward(req,resp);
        }else {

            resp.sendRedirect("shoppingCart");
        }
    }
}

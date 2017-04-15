package service;

import Dao.pageUser_Information;
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
        pageUser_Information sign = new pageUser_Information();
        if (l == 1){
            sign.sign = 1;
            sign.name = null;
            sign.email = null;
            req.setAttribute("sign",sign);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else if (l == 2){
            sign.sign = 2;
            sign.name = null;
            sign.email = null;
            req.setAttribute("sign",sign);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            sign.sign = 0;
            sign.name = userDao.GetPageUser(user.email);
            sign.email = user.email;
            req.setAttribute("sign",sign);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}

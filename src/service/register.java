package service;

import Dao.userDao;
import Dao.user_Information;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 17853 on 2017/4/14.
 * register
 */
public class register extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        user_Information user = new user_Information();
        user.email = email;
        user.name = name;
        user.password = password;
        int l = userDao.register(user);
        if (l == 0) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("register_ok.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("login.html").forward(req,resp);
        }
    }
}

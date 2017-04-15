package service;

import Dao.pageUser_Information;
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
public class register extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passeword1 = req.getParameter("password1");
        user_Information user = new user_Information();
        user.email = email;
        user.name = name;
        user.password = password;
        char[] Email = email.toCharArray();
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if ('@' == Email[i]) {
                if ('.' == Email[i + 1]) {
                    count++;
                }
            }
        }
        int l = userDao.register(user);
        if (email.equals("") || name.equals("") || password.equals("") || count != 1 || !passeword1.equals(password)) {
            int s = 3;
            req.setAttribute("sign", s);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (l == 0) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("register_ok.jsp").forward(req, resp);
        } else if (l == 1) {
            int sign = 2;
            req.setAttribute("sign", sign);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else if (l == 2) {
            int s = 1;
            req.setAttribute("sign", s);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}

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
 * add order
 */
public class AddOrder extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String zipCode = req.getParameter("zipCode");
        String telephone = req.getParameter("telephone");
        String mobilePhone = req.getParameter("mobilePhone");
        String username = req.getParameter("username");
        Order_Information order = new Order_Information();
        order.name = name;
        order.address = address;
        order.zipCode = zipCode;
        order.telephone = telephone;
        order.mobilePhone = mobilePhone;
        OrderDao.OrderAdd(order,username);
        if (name.equals("") || address.equals("") || zipCode.equals("") || telephone.equals("") || mobilePhone.equals("")){
            int sign = 1;
            req.setAttribute("sign",sign);
            req.getRequestDispatcher("address_form.jsp").forward(req,resp);
        }else {
            req.setAttribute("money", order);
            req.getRequestDispatcher("order_ok.jsp").forward(req, resp);
        }
    }
}

<%@ page import="Dao.pageUser_Information" %><%--
  Created by IntelliJ IDEA.
  User: 17853
  Date: 2017/4/14
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 - 当当网</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <link href="css/page_bottom.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.4.min.js"></script>
    <script type="text/javascript" src="js/verify.js"></script>
    <script type="text/javascript" src="js/loginFormValidate.js"></script>
    <script type="text/javascript" src="userLoginIn.js"></script>
</head>
<body>
<div class="login_top">
    <a href="#" target="_blank"><img class="logo"
                                     src="images/logo.gif" /> </a>
</div>

<div class="enter_part">
    <div class="introduce">
        <img src="images/d_introduce.gif" />
        <ul>
            <li>
                更多选择
            </li>
            <li class="bj_none">
                60万种图书音像，共计百万种商品。
            </li>
            <li>
                更低价格
            </li>
            <li class="bj_none">
                电视购物的3-5折，传统书店的5-7折，其他网站的7-9折。
            </li>
            <li>
                更方便、更安全
            </li>
            <li class="bj_none">
                全国超过300个城市送货上门、货到付款。零风险购物，便捷到家。
            </li>
        </ul>
    </div>

    <div class="enter_in">
        <div class="bj_top"></div>
        <div class="center">
            <div style="height: 30px; padding: 5px; color: red"
                 id="divErrorMssage">
                <br />
            </div>
            <div class="main">
                <h3>
                    登录当当网
                </h3>
<%
    pageUser_Information sign = (pageUser_Information) request.getAttribute("sign");
%>
                <form method="post" action="login" id="from">
                    <ul>
                        <li>
                            <span>请输入Email地址：</span>
                            <input type="text" name="email" id="email" class="textbox" placeholder="<% out.print(sign.email); %>">
                        </li>
                        <li>
                            <span class="blank">密码：</span>
                            <input type="password" name="password" id="password" class="textbox">
                        </li>
                        <li style="display: none" id="sign"><% out.print(sign.sign); %></li>
                        <li style="display: none" id="name"><% out.print(sign.name); %></li>
                        <li style="display: none" id="userEmail"><% out.print(sign.email); %></li>
                        <li>
                            <input type="submit" value="验证" class="button_enter"><span id="yanZh"><% if (sign.sign == 0){out.print("验证通过");}else {out.print("验证失败");}%></span>
                        </li>
                        <li>
                            <input type="button" value="登录" class="button_enter" onclick="LoginIN()">
                        </li>
                        <li><input type="button" onclick="init()" value="刷新"></li>
                    </ul>
                </form>
            </div>
            <div class="user_new">
                <p>
                    您还不是当当网用户？
                </p>
                <p class="set_up">
                    <a href="/register_jsp">创建一个新用户&gt;&gt;</a>
                </p>
            </div>
        </div>
    </div>
</div>
<div>
    <center>
        <hr style="height: 1px; width: 972px; color: #cfcfcf" />
        <div class="b_left"></div>
        <div class="publish_bottom_message2">
            <div class="copyright">
                Copyright (C) 当当网 2004-2008, All Rights Reserved
            </div>
            <div class="validate">
                <a
                        href="#http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001051000098"
                        target="_blank"> <img src="images/validate.gif" border="0" />
                </a>
                <p>
                    <a href="" target="_blank">京ICP证041189号</a>
                </p>
            </div>
        </div>
    </center>
</div>

</body>
</html>

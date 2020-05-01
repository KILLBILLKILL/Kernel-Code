package feihong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/f")
public class ForwordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码以及响应类型：在servlet中都要设置
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");//响应响应体
        //设置浏览器解析的类型：响应头Content-Type值是什么
        resp.setContentType("text/html; charset=UTF-8");


        //响应数据给客户端

        String key=req.getParameter("key");
        if("1".equals(key))
        {
            //重定向 :不限制是否在本域名内
            resp.sendRedirect("http://localhost:8080/ss/shenlong");
        }
        else{
            //Servlet转发  限制在本域名内+本项目
            req.getRequestDispatcher("/shenlong").forward(req,resp);
        }

    }
}

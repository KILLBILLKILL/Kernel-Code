package feihong.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shenlong")
public class CallShenlongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码以及响应类型：在servlet中都要设置
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");//响应响应体
        //设置浏览器解析的类型：响应头Content-Type值是什么
        resp.setContentType("text/html; charset=UTF-8");

        //响应数据给客户端
        PrintWriter pw=resp.getWriter();
        //获取当前http请求的用户的session信息，
        //如果获取不到就直接null
        HttpSession session=req.getSession(false);

        if(session==null)
        {
            pw.println("找不到神龙");
        }
        else{
            String user=(String)session.getAttribute("user");
            //校验用户是否有访问当前url的权限
            if("stu=123".equals(user))//模拟校验
            {
                pw.println("呼唤来了 (*^_^*)");
            }
            else {
                pw.println("没有呼唤来神龙");
            }
        }
        pw.flush();
    }
    }


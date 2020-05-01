package feihong.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
//浏览器访问/login这个路径就可以执行servleth中的service方法
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码以及响应类型：在servlet中都要设置
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");//响应响应体
        //设置浏览器解析的类型：响应头Content-Type值是什么
        resp.setContentType("text/html; charset=UTF-8");
        //获取请求数据，通过键获取值 如果获取不到，值就等于null
        String username=req.getParameter("username");
        String paaaword=req.getParameter("password");
        //响应数据给客户端
        PrintWriter pw=resp.getWriter();
        //模拟用户登陆的校验步骤
        if(!"stu".equals(username)||!"123".equals(paaaword))
        {
            resp.setStatus(403);
            pw.println("<p>用户名或密码错误<p>");
        }
        else{
            // getSession()=getSession(true)
            // 表示获取当前用户的session信息，如果获取不到，就创建一个
            HttpSession session=req.getSession();
            session.setAttribute("user",username+"="+paaaword);
            pw.println("登陆成功");
        }
        pw.flush();
    }
}

package webserv;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    AuthenServlet auth = new AuthenServlet();

//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response){
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String intendedPath = request.getParameter("intendedPath");
        RequestDispatcher rd = null;

        request.getInputStream();
        boolean valid = this.auth.check(new User(email,password));
        if (valid){
            request.getSession().setAttribute("login_status","ok");
            if (intendedPath!=null){
                rd = request.getRequestDispatcher(intendedPath);
            }else{
                rd = request.getRequestDispatcher("index.jsp");
            }
            // response.addCookie(new Cookie("name",email));
            // session attribute is used for authentication. Kind of similar to cookie mechanism
            rd.forward(request,response);
        }else {
            request.setAttribute("msg","Login credentials are not correct.");
            request.getSession().setAttribute("login_status","fail");
            rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);

        }
    }
}

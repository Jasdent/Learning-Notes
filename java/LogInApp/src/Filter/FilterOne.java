package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterOne implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter Start");
        // login authentification to see if log in is required
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession sess = request.getSession();
        sess.setAttribute("blah","iorvriob");
        String path = request.getServletPath();
        // either action in form or href in anchor, it can be path to an existing file
        // or directly enter a servlet
        // this is what user originally intend to access
        String login_status = (String) sess.getAttribute("login_status");

        RequestDispatcher rd = null;
        String forward = null;
        System.out.println("path "+path);

//        for (int i = 0; i<10;i++) {
//            chain.doFilter(request, response);
//            System.out.println("FilterOne doFilter "+i);
//            // return;
//        }
        // (Filter -> chain.DoFIlter)->(Filter -> chain.DoFIlter)->(Filter -> chain.DoFIlter)
        // 有点并发的感觉

         //doFilter 从上到下，能多次执行 chain.doFilter
        if (path!=null
                && (path.equals("/index.jsp")
                || path.equals("/login.jsp")
                || path.equals("/login")
                || path.equals("/logout"))){
            // proceed anyways without the need for authentication
            // System.out.println("ENTER 1");
            chain.doFilter(request,response);
            return;
        }
        if (login_status != null && login_status.equals("ok")){
            // proceed to all intended path with authentication
            // System.out.println("ENTER 2");
            chain.doFilter(request,response);
            return;
        }else if(login_status != null && login_status.equals("fail")){
            // System.out.println("ENTER 3");
            request.setAttribute("msg","login credentials are not correct");
            forward = "login.jsp";
            request.setAttribute("intendedPath",path);
            rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);
            return;
        }else{
            // System.out.println("ENTER 4");
            request.setAttribute("msg","Please login");
            forward = "login.jsp";
            request.setAttribute("intendedPath",path); // this step might be more helpful under complicated context
            rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);
            return;
        }
    }

    public void init(FilterConfig config) throws ServletException {
        String encode = config.getInitParameter("CharEncode");
    }

}

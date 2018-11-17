package controller;

import org.springframework.ui.Model;
import pojo.*;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
//@RequestMapping("/exercise")
public class HelloController implements Controller{

    // access the method under localhost/exercise/lala
    @Override
    @RequestMapping("/lala")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Hello Spring MVC");
        return mav;
    }


    /*
    * THIS IS SO CONVENIENT! I don't have to specify the
    * servlet name, class and mapping on the web.xml which might become
    * kind of hairy if a lot of pages are under development.
    * mapping: link the form with the configuration
    * servlet name: link the servlet name to an actual class
    * NOW WITH SPRING, I don't need to do this!!
    * */
//    @RequestMapping("/login")
//    public ModelAndView getParam(HttpServletRequest request, HttpServletResponse response){
//      System.out.println(request.getParameter("username"));
//      System.out.println(request.getParameter("password"));
//      return null;
//    }

    @RequestMapping("/login")
    public ModelAndView getParam(
            User user
    ){
        // FIND OUT HOW ON EARTH THIS IS DONE
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        ModelAndView mav = new ModelAndView("redirect:/welcome");
        return mav;
    }

    @RequestMapping("/welcome")
    public ModelAndView justdoit(HttpServletRequest request, HttpServletResponse response){
        System.out.println("FUCK YEAH, REACAHED HERE");
        return null;
    }

//    @RequestMapping("/login")
//    public ModelAndView getParam(
//            @RequestParam(value="username",required = true) String username,
//            @RequestParam(value = "password",required = true) String password){
//        System.out.println(username);
//        System.out.println(password);
//        return null;
//    }
}

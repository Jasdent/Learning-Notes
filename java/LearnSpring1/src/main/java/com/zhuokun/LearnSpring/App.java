package com.zhuokun.LearnSpring;

import com.zhuokun.Beans.FileNameGenerator;
import com.zhuokun.annotationtest.BankUser;
import com.zhuokun.customer.service.CustomerService;
import com.zhuokun.collection.Customer;
import com.zhuokun.collection.Person;
import com.zhuokun.loose_coupling.OutputHelper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.util.*;

public class App 
{
    private static ApplicationContext context;

    public static void main( String[] args ) {

//        // Method 1
//        // work as the name indicates: application context class path refered to xml
//        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        // getBean by id, the structure of the class is referenced in the xml with an absolute path
//        // then, fit in the configuration data into the structure and returb object
//        // then, cast to the desired type
//        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
//        obj.printHello();


//        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        // what i can access using autosuggestion in intellij depends on compile time type method
//        // in this case the methods refers to applicationcontext interface
//        OutputHelper helper = (OutputHelper) context.getBean("outputhelper");
//        helper.output();
//
//        BeanFactory factory = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        ((OutputHelper)factory.getBean("outputhelper")).output();


        // 给 bean 通过 xml 注入属性
        // context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        // FileNameGenerator generator = (FileNameGenerator) context.getBean("FileNameGenerator");
        // generator.printFileName();

        // 嵌套 Bean
        // context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        // Customer customer = (Customer) context.getBean("Customer");
        // System.out.println(customer.toString());

        // CustomerService customerService = (CustomerService) context.getBean("CustomerServ");
        // customerService.setMessage("I love Brandy");
        // System.out.println("Message of customerService: " + customerService.getMessage());

        // CustomerService customerService2 = (CustomerService) context.getBean("CustomerServ");
        // System.out.println("Message of customerService2: " + customerService2.getMessage());

//        context = new ClassPathXmlApplicationContext("SpringCollectionsBean.xml");
//        Customer customer1= (Customer) context.getBean("111"); // get by id, get by name, same
//        System.out.println(customer1.getLists().toString());
//        System.out.println(customer1.getSets().toString());
//        System.out.println(customer1.getMaps().toString());
//        System.out.println(customer1.getPros().toString());
//
//        Customer customer2= (Customer) context.getBean("customer"); // get by id, get by name, same
//        System.out.println(customer2.getLists().toString());
//        System.out.println(customer2.getSets().toString());
//        System.out.println(customer2.getMaps().toString());
//        System.out.println(customer2.getPros().toString());
        context = new ClassPathXmlApplicationContext("AnnotationTestContext.xml");
        BankUser user1 = (BankUser) context.getBean("bankuser");





    }
}

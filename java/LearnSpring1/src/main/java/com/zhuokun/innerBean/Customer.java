package com.zhuokun.innerBean;

import org.springframework.stereotype.Component;

@Component
public class Customer {
    Person person;


    public void setPerson(Person person){
        this.person = person;
    }

    @Override
    public String toString(){
        return "Customer [person=" + this.person + "]";
    }

}

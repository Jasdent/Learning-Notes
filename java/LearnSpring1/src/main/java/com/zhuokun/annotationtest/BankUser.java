package com.zhuokun.annotationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bankuser")
public class BankUser {
    private String email,mobile_phone,name;
    @Autowired
    private SmartAccess smartAccess;

    public BankUser(){
        System.out.println("Damn");
    }

    public BankUser(String args){
        System.out.println(args);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SmartAccess getSmartAccess() {
        return smartAccess;
    }

    public void setSmartAccess(SmartAccess smartAccess) {
        this.smartAccess = smartAccess;
    }
}

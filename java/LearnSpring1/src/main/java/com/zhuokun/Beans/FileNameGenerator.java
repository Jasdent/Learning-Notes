package com.zhuokun.Beans;

public class FileNameGenerator {
    private  String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printFileName(){
        System.out.println("Filename: "+this.name + " File Type: "+this.type);
    }
}

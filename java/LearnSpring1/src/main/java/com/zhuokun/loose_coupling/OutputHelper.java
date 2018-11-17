package com.zhuokun.loose_coupling;

public class OutputHelper {
    IOGenerator generator;

    public void output(){
        this.generator.output();
    }

    public void setGenerator(IOGenerator generator){
        this.generator = generator;
    }
}

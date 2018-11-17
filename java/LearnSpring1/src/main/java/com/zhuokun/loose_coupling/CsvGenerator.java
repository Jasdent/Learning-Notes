package com.zhuokun.loose_coupling;

public class CsvGenerator implements IOGenerator{
    @Override
    public void output(){
        System.out.println("CSV output generator started ... ");
    }
}

package com.zhuokun.annotationtest;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.Map;
import java.util.Date;

@Component
public class SmartAccess {
    private float balance;
    private float rate;
    private Map<Date, ResultSet> records;

}

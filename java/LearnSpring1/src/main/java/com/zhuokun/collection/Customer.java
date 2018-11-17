package com.zhuokun.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Customer {
    private List<Object> lists;
    private Set<Object> sets;
    private Map<Object,Object> maps;
    private Properties pros;
    private Person person;

    public Customer(Person person){
        this.person = person;
    }

    public Customer(){
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Map<Object, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public Properties getPros() {
        return pros;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    @Override
    public String toString(){
        return "Customer [person" + this.person.toString() + "]";
    }
}

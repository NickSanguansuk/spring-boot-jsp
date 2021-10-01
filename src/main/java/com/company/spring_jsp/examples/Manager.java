package com.company.spring_jsp.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Manager {
    private LazyWorker lw;
    private GoodWorker gw;
    private GreatWorker gtw;

    @Autowired
    public Manager(LazyWorker lw, GoodWorker gw, GreatWorker gtw) {
        this.lw = lw;
        this.gw = gw;
        this.gtw = gtw;
    }

    public static void main(String[] args) {

        LazyWorker lw = new LazyWorker();

    }
}

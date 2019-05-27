package com.ssm.demo.ManyThread;

public class CookAndServe {
    private static final int MAX_COOK_COUNT = 10;// 设定准备食物的数量

    public static void main(String[] args) {
        OrderAndServer os = new OrderAndServer();
        Order od = new Order(os, MAX_COOK_COUNT);
        Serve sv = new Serve(os, MAX_COOK_COUNT);
        Thread cook = new Thread(od);
        Thread serve = new Thread(sv);
        cook.start();
        serve.start();
    }
}

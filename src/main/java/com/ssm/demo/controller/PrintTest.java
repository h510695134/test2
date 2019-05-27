package com.ssm.demo.controller;

public class PrintTest implements Runnable {

    @Override
    public void run() {
        System.out.println("输出一行字");
    }
}

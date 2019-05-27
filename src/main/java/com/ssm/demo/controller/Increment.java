package com.ssm.demo.controller;

public class Increment {

    private int i;

    public void increase(){
        i++;
    }
    public int getI(){
        return i;
    }

    public static void test(int threadNum,int loopTimes){
        Increment increment = new Increment();

        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threads.length;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < loopTimes; i++){
                        increment.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadNum + "个线程，循环" + loopTimes + "次结果：" + increment.getI());

    }

    public static void main(String[] args) {
        test(20,1);
    }
}

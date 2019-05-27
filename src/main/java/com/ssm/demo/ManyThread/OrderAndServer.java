package com.ssm.demo.ManyThread;

/**
 * 模拟厨师和服务员需要完成的等待和通知的动作
 */
public class OrderAndServer {

    // 判断厨师是否准备好食物
    private boolean finishFlag = false;

    public synchronized void order(int number){
        // 厨师做了几道菜
        System.out.println(" The cook have done the "+number+" food");
        while (finishFlag == true){// 厨师准备好食物
            try {
                wait(); // 等待服务员来取
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
        }
        finishFlag = true; // 设置厨师准备好食物标志为true
        notifyAll();//通知服务员来取食物
    }
    public synchronized void serve(int number){
        while (finishFlag == false){ // 厨师没有准备好食物的情况下
            try {
                wait(); // 等待厨师准备食物
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 服务员能取几道菜
        System.out.println("the waiter can got the "+number+" food");
        finishFlag = false; // 设置厨师没有准备好食物标志为false
        notifyAll(); // 通知厨师食物已取走
    }
}

package com.ssm.demo.ManyThread;

/**
 * 模拟厨师操作
 */
public class Order implements Runnable {
    OrderAndServer os;
    int MAX_COOK_COUNT; //定义准备食物数量
    Order(OrderAndServer co,int MAXC){
        os = co;
        MAX_COOK_COUNT = MAXC;
    }
    @Override
    public void run() {
        int i;
        for (i = 1; i <= MAX_COOK_COUNT;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.toString());
            }
            os.order(i); // 调用order方法,执行线程之间的通信
        }
    }
}

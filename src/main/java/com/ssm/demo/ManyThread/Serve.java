package com.ssm.demo.ManyThread;

/**
 * 模拟服务员多线程操作
 */
public class Serve implements Runnable {
    OrderAndServer os; // 创建orderandserver对象
    int MAX_COOK_COUNT; //定义准备食物数量

    Serve(OrderAndServer co,int MAXC){
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
            os.serve(i); // 调用serve方法,执行线程之间的通信
        }
    }
}

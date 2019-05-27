package com.ssm.demo.ThreadDemo;

public class TicketThread {
    public static void main(String[] args) {
        // 初始化票数
        Ticket tk = new Ticket(5);

        /**
         * 模拟三个购票者
         */
        WithBuyTicket b1 = new WithBuyTicket(tk, 2);
        WithBuyTicket b2 = new WithBuyTicket(tk, 1);
        WithBuyTicket b3 = new WithBuyTicket(tk, 3);

        // 创建三个线程
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        Thread t3 = new Thread(b3);

        t1.start();
        t2.start();
        t3.start();
    }
}

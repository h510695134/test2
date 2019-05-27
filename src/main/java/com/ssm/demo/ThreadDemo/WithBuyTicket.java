package com.ssm.demo.ThreadDemo;

public class WithBuyTicket implements Runnable {
    Ticket tc;
    int i ;
    WithBuyTicket(Ticket t, int j){
        tc = t;
        i = j;
    }
    @Override
    public void run() {
        tc.buyTicket(i);
    }
}

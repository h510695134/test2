package com.ssm.demo.ThreadDemo;

public class Ticket {

    // 车票总数
    private int ticketCount;

    Ticket(int tc){
        this.ticketCount=tc;
    }

    synchronized int buyTicket(int amount){
        int currentTicketAmount = ticketCount;
        System.out.println("目前的票数: " + ticketCount);
        if (currentTicketAmount < amount){
            // 剩余数不足
            System.out.println("需要售出: "+amount+",剩下的票数是: "+currentTicketAmount+"...剩余票数不足!");
            return ticketCount;
        }
        for (int i = 0 ; i < 10000; i++){}
        currentTicketAmount = currentTicketAmount - amount;
        System.out.println("售出票数 : "+ amount+"张, "+"剩下的票数:  "+currentTicketAmount);

        if (currentTicketAmount <= 0){
            System.out.println("票已经卖光!");
            ticketCount = currentTicketAmount;
        }else{
            ticketCount = currentTicketAmount;
        }
        return ticketCount;
    }
}

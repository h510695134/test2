package com.ssm.demo.ManyThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private int i;

    // 写
    public void setI(int a){
        writeLock.lock();
        try {
            i = a;
        }finally {
            writeLock.unlock();
        }
    }

    // 读
    public int getI(){
        readLock.lock();
        try {
            return i;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        new AtomicInteger();
    }
}

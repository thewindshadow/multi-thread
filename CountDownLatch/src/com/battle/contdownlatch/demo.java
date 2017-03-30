package com.battle.contdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Bing.Z on 2017/3/28.
 */
public class demo {
    public static void main(String[] args) {
        Latch();
    }


    public static void Latch(){
        final CountDownLatch startLatch = new CountDownLatch(1);  //想象成这把锁需要开一次就能打开
        final CountDownLatch endLatch = new CountDownLatch(3); //想象成这把锁需要开三次才能打开
        Runnable prepare = new Runnable() {
            @Override
            public void run() {
                try {
                    startLatch.await();//等待;开始闭锁，线程同时开始执行，等待别人手动打开锁
                    System.out.println("1");
                    System.out.println("准备出门");
                    Random rnd = new Random();
                    Thread.sleep(rnd.nextInt(1000));
                    System.out.println("2");
                } catch (InterruptedException ignored) {
                }
                endLatch.countDown();
                System.out.println("3");
            }
        };
        Thread mum = new Thread(prepare);
        Thread dad = new Thread(prepare);
        Thread me = new Thread(prepare);
        mum.start();
        dad.start();
        me.start();
        System.out.println("4");
        startLatch.countDown();  //准备好了，主线程开锁
        System.out.println("5");
        try {
            System.out.println("6");
            endLatch.await();  //主线程也被上了锁，不过这次可以解开锁的人是三个人
            System.out.println("7");
        } catch (InterruptedException ignored) {
        }
        System.out.println("逛街");
    }
}

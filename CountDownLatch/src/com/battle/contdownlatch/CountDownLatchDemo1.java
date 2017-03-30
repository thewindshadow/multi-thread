package com.battle.contdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class CountDownLatchDemo1 {


    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        final CountDownLatch count = new CountDownLatch(3);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("收拾衣服！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(count != null){
                        count.countDown();
                    }
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("购生活用品！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(count != null){
                        count.countDown();
                    }
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("购车票！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(count != null){
                        count.countDown();
                    }
                }
            }
        });


        try {
            count.await();
            System.out.println("出发！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

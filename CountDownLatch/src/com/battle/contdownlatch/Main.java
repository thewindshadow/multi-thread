package com.battle.contdownlatch;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class Main {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
//        boolean result = false;
//        try {
//            result = ApplicationStartupUtil.checkExternalServices();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("External service result :" + result);

    }
}

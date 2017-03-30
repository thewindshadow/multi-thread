package com.battle.contdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "CacheService");
    }

    @Override
    public void verifyService() {
        System.out.println("checking:"+this.getServiceName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+"is up");
    }
}

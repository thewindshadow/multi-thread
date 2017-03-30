package com.battle.contdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "Database Service");
    }

    @Override
    public void verifyService() {
        System.out.println("checking:"+this.getServiceName());
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + "is up");
    }
}

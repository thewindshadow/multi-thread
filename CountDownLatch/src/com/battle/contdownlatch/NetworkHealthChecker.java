package com.battle.contdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "NetWorkService");
    }


    @Override
    public void verifyService() {
        System.out.println("Checking:"+this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+" is up");
    }
}

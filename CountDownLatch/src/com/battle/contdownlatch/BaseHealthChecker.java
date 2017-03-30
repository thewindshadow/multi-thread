package com.battle.contdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public abstract class BaseHealthChecker implements Runnable  {
    private CountDownLatch countDownLatch;
    private String serviceName;
    private boolean serviceUp;
    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super();
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            serviceUp = false;
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public void setServiceUp(boolean serviceUp) {
        this.serviceUp = serviceUp;
    }

    /**
     * This method needs to be implemented by all specific service checker
     */
    public abstract void verifyService();
}

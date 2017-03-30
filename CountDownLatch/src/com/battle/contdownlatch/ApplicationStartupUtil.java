package com.battle.contdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Bing.Z on 2017/3/29.
 */
public class ApplicationStartupUtil {
    private static List<BaseHealthChecker> baseList;
    private static CountDownLatch countDownLatch;

    private ApplicationStartupUtil(){

    }
    private static final ApplicationStartupUtil instance = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance(){
        return instance;
    }

    public static boolean checkExternalServices() throws Exception{

        countDownLatch = new CountDownLatch(3);
        baseList = new ArrayList<>();
        baseList.add(new DatabaseHealthChecker(countDownLatch));
        baseList.add(new CacheHealthChecker(countDownLatch));
        baseList.add(new NetworkHealthChecker(countDownLatch));
        Executor executor = Executors.newFixedThreadPool(baseList.size());
        for (final BaseHealthChecker base : baseList) {
            executor.execute(base);
        }
        countDownLatch.await();

        for (final BaseHealthChecker base : baseList) {
            if(!base.isServiceUp()){
                return false;
            }
        }


        return true;
    }
}

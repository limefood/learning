package org.linn.learning.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        // 如果池中没有可用的线程，则将创建一个新线程并将其添加到池中，60秒内未使用的线程将被终止并从缓存中删除。
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        // 已经提交的任务将继续被执行，但不接受新的任务。如果已经关闭，则调用没有额外的效果。
        exec.shutdown();
    }
}
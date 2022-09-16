package top.starp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.AbortPolicy()
// new ThreadPoolExecutor.CallerRunsPolicy()
// new ThreadPoolExecutor.DiscardOldestPolicy()
//new ThreadPoolExecutor.DiscardPolicy()
        );


        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getId() +
                        "[" + finalI + "] -- 开始");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + +finalI + "] -- 结束");
            });
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        boolean notTerminal= true;

        try {
            do {
                notTerminal = !executor.awaitTermination(1, TimeUnit.SECONDS);
            } while (notTerminal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程池关闭成功。。。");
        System.out.println(Thread.currentThread().getId());
    }
}
//14[0] -- 开始
//        15[1] -- 开始
//        16[2] -- 开始
//        17[6] -- 开始
//        18[7] -- 开始
//        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task top.starp.ThreadPoolExecutorDemo$$Lambda$14/0x0000000840064c40@34c45dca rejected from java.util.concurrent.ThreadPoolExecutor@52cc8049[Running, pool size = 5, active threads = 5, queued tasks = 3, completed tasks = 0]
//        at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2055)
//        at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:825)
//        at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1355)
//        at top.starp.ThreadPoolExecutorDemo.main(ThreadPoolExecutorDemo.java:24)
//        14] -- 结束
//        14[3] -- 开始
//        16] -- 结束
//        15[4] -- 开始
//        18] -- 结束
//        16[5] -- 开始
//        23] -- 结束
//        25] -- 结束
//        17] -- 结束
//        19] -- 结束
//        21] -- 结束

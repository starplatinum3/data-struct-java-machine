package top.starp.util;

public class OddEvenPrinter {

    private Object monitor = new Object();
    private final int limit;
    private volatile int count;

    OddEvenPrinter(int initCount, int times) {
        this.count = initCount;
        this.limit = times;
    }

    public static void main(String[] args) {

        OddEvenPrinter printer = new OddEvenPrinter(0, 10);
        new Thread(printer::print, "odd").start();
        new Thread(printer::print, "even").start();
    }

    private void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字:%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
//                    其他人 可以了
//                    自己睡觉了
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
            monitor.notifyAll();
        }
    }
}

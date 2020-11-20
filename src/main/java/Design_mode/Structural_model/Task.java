package Design_mode.Structural_model;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
    private long num;

    public Task(long num) {
        this.num = num;
    }

    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result:" + r);
        return r;
    }
}

//class Main {
//    public static void main(String[] args) {
//        Callable<Long> callable = new Task(123450000L);
//        Thread thread = new Thread(new RunnableAdapter(callable));
//        thread.start();
//    }
//}
//
//class RunnableAdapter implements Runnable {
//    // 引用待转换接口:
//    private final Callable<?> callable;
//
//    public RunnableAdapter(Callable<?> callable) {
//        this.callable = callable;
//    }
//
//    // 实现指定接口:
//    public void run() {
//        // 将指定接口调用委托给转换接口调用:
//        try {
//            callable.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

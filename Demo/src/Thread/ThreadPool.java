package Thread;

import java.util.concurrent.*;

/**
 * Created by Clanner on 2017/10/18.
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executor =  Executors.newSingleThreadExecutor();

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
        }
        executor.shutdown();
    }

    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }
}

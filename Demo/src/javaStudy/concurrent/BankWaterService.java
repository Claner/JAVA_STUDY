package javaStudy.concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Clanner on 2018/2/9.
 */
public class BankWaterService implements Runnable {

    //设置4个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier c = new CyclicBarrier(4);

    //假设只有4个sheet，启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    //保存每个sheet计算出来的结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(() -> {
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    //计算完成，插入屏障
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        //将结果输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
        new Thread(bankWaterCount).start();
    }
}

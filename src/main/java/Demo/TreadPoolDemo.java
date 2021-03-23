package Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：liss13
 * @date ：Created in 2021/3/1 21:24
 * @description：线程池测试
 */
public class TreadPoolDemo {

    public static void main(String[] args) {
        Runnable printA = new PintChart('a', 100);
        Runnable printB = new PintChart('b', 100);
        Runnable printC = new PintNum(100);

        ExecutorService executor = Executors.newFixedThreadPool(3);  //创建三个线程来并发执行三个任务
//        ExecutorService executor = Executors.newFixedThreadPool(1);   //线程池中只有一个线程，顺序执行三个任务
//        ExecutorService executor = Executors.newCachedThreadPool();   //为每个任务新建一个线程，三个任务并行执行
        executor.execute(printA);
        executor.execute(printB);
        executor.execute(printC);

        executor.shutdown();
    }

}
    class PintChart implements Runnable{
        private int times;
        private char chartToPrint;

        public PintChart(char c,int t){
            times=t;
            chartToPrint=c;
        }

        @Override
        public void run() {
            for (int i=0;i<times;i++){
                System.out.println(chartToPrint);
            }
        }
    }

    class PintNum implements Runnable{
        private int lastNum;

        public PintNum(int t){
            lastNum=t;
        }

        @Override
        public void run() {
            for (int i=1;i<=lastNum;i++){
                System.out.println(lastNum);
            }
        }
    }

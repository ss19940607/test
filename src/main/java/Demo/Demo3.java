package Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行紧张的计算。。。");
        Thread.sleep(200);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        Demo3 demo3 = new Demo3();
        FutureTask<Integer> tasks = new FutureTask<>(demo3);
        //对线程任务的一个封装FutureTask实现RunnableFuture接口，
        // RunnableFuture接口实现Runnable接口，所以可以tasks可以包装到线程里面执行了
        Thread thread = new Thread(tasks);
        thread.start();
        System.out.println("我先干点别的");
        //FutureTask提前完成任务，创建线程的一种掩饰
        tasks.run();
        Integer result = tasks.get();
        System.out.println("线程执行的结果--"+result);

    }
}

package Demo;

public class Demo extends Thread {

    public Demo(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {//判断线程中断标识，如果没有中断就继续执行，相反不执行
            System.out.println(getName() + "执行了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Demo d1 = new Demo("first-thread");
        Demo d2 = new Demo("second-thread");

        //指定Daemon,守护线程，支持性线程，后台调用，
        // 做一些支持性工作，如垃圾回收，扔在后台执行，
        // 线程任务并没有执行完毕，但是主线程依然让他退出；
        // 线程还诶有执行就退出去了；
        // 当前线程休息两秒钟，然后执行，
        // 虽然两秒钟之后他的任务没有完成，
        // 但是他依然随着主线程的结束而终止执行；

        d1.setDaemon(true);
        d2.setDaemon(true);

        d1.start();
        d2.start();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        d1.stop();
        //stop ：线程所获取的锁，资源都没有释放掉，
        // 会让线程无限期的等待下去，所以不推荐使用，很不好
        d1.interrupt();//并没有让我们的线程终止掉，这是代码写的有问题
    }

}

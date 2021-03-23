package Demo;

public class Demo1 implements Runnable {
    @Override
    public void run(){
        while (true){
            System.out.println("线程执行了!");
        }
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new Demo1());
        thread.start();
    }
}

package Demo;
//匿名内部类创建线程
public class Demo2 {
    public static void main(String[] args) {
//        new Thread(){//重写run
//            public void run(){
//                System.out.println("runing");
//            };
//        }.start();
        //子类重写父类的run方法

        //Java 动态分派调用   jvm虚拟机多态的实现原理
        // 执行子类的run方法不执行父类的

        new  Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("继承父类的");
                    }
                }
        ){
            public void run(){
                System.out.println("重写run方法，执行");
            }
        }.start();
    }
}

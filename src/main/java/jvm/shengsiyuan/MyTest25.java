package jvm.shengsiyuan;

/**
 * @ClassName MyTest25
 * @Description
 * @Date 2019/5/20 10:24 PM
 * @Version v1.0
 **/
public class MyTest25 implements Runnable{

    private Thread thread;

    MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}

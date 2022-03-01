package jvm.shengsiyuan;

/**
 * 加载
 * 链接（验证，准备，解析）
 * 初始化
 *
 * 该实例的主要目的主要是为了说明类的加载，链接和初始化的顺序。一定要记住在链接阶段中的准备阶段是jvm根据变量的类型自动赋初值；
 * 然后到了初始化阶段才将用户显示定义的变量的初始值赋值给变量
 **/
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        /*System.out.println("counter1: " + Singleton.counter1); //counter1: 1
        System.out.println("counter2: " + Singleton.counter2); //counter2: 1*/

        System.out.println("counter1: " + Singleton.counter1); //counter1: 1
        System.out.println("counter2: " + Singleton.counter2); //counter2: 0
    }
}

/*class Singleton {
    public static int counter1;

    public static int counter2 = 0;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}*/

class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}

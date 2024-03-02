package jvm.shengsiyuan;

/**
 * @ClassName MyTest24
 * @Description
 * @Date 2019/5/16 11:59 PM
 * @Version v1.0
 **/
public class MyTest24 {

    public static void main(String[] args) {
        // 输出 sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 输出 null
        System.out.println(Thread.class.getClassLoader());
    }
}

package jvm.shengsiyuan;

/**
 * @ClassName MyTest12
 * @Description
 * @Date 2019/4/2 11:05 PM
 * @Version v1.0
 **/

class CL {

    static {
        System.out.println("Class CL");
    }
}

/**
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 **/
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("jvm.shengsiyuan.CL");

        System.out.println(clazz);

        System.out.println("------------");

        clazz = Class.forName("jvm.shengsiyuan.CL");

        System.out.println(clazz);
    }
}

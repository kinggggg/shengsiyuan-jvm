package shengsiyuan;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName MyTest26
 * @Description
 *
 * 线程上下文类加载器的一般使用模式（获取 - 使用 - 还原）
 *
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 *
 * try{
 *     Thread.currentThread().setContextClassLoader(targetTccl);
 *     myMethod();
 * } finally {
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 *
 * myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。
 *
 * 如果一个类由加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
 *
 * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或者实例化）低层的类时，就必须要通过线上上下文类加载器来帮助高层的ClassLoader找到并
 * 加载该类
 *
 *  通过上一节我们已经知道：在默认的情况下一个线程的上下文类加载是系统类加载器
 *
 * @Date 2019/5/20 10:43 PM
 * @Version v1.0
 **/
public class MyTest26 {

    public static void main(String[] args) {

        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator =
                serviceLoader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();

            System.out.println("Driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoaderd的类加载器： " + ServiceLoader.class.getClassLoader());

    }

}

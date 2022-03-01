package jvm.shengsiyuan;

/**
 * 在运行期，一个Java类是由该类的完全限定名（binary name，二进制名）和用于加载该类的定义类加载器（defining loader）所共同决定的
 * 如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完全一样，并且从相同的
 * 位置加载亦是如此
 **/

//import sun.misc.Launcher;

/**
 * 由上可以想到：
 *  在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下错误信息：
 *
 *  ➜  classes git:(master) ✗ java -Dsun.boot.class.path=. shengsiyuan.MyTest23
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 *
 **/
public class MyTest23 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /**
         * 内建与JVM中的启动类加载器会加载java.lang.ClassLoader（指用户自定义的类加载器）以及其他的Java平台类（指包括例如java.lang.Object等类）
         * 当JVM启动时，一块特殊的机器码会运行，它会加载包括扩展类加载器和应用类加载器，这块特殊的机器码叫做启动类加载器（Bootstrap类加载器，也就是启动类加载器）
         *
         * 启动类加载器并不是Java类，而其他的加载器则都是Java类。
         * 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程
         *
         * 所有的类加载器（除了启动类加载器）都被实现为Java类。不过， 总归要有一个组件来加载第一个Java类加载器，从而让加载过程能够顺利进行下去，
         * 加载第一个纯Java类加载器就是启动类加载器的职责
         *
         * 启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等
         **/
        System.out.println(ClassLoader.class.getClassLoader());

        //扩展类加载和系统类加载器也是由启动类加载器的。判断的思路是这样的，当一个加载器a加载一个类b的时候，如果在类b当中对类c有引用，那么加载器a同样也会加载类c，此时加载器a就是类c的加载器。因为在JDK源码中我们看到
        //无论是扩展类加载器ExtClassLoader还是应用类加载器AppClassLoader，都不是public的，而是Launcher类中的一个内部类，而Launcher是public的，于是找到了Launcher类的加载器就找到了扩展类和应用类加载器的加载器
//        System.out.println(Launcher.class.getClassLoader());

        System.out.println("------------");


        /**
         * 以下代码在IDE中输出如下：
         * null
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         *
         * 通过如下的命令运行
         * java -Djava.system.class.loader=shengsiyuan.MyTest16 shengsiyuan.MyTest23
         * 输出如下
         * shengsiyuan.MyTest16
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * shengsiyuan.MyTest16@4e25154f
         *
         * 看到应用类加载器已经变为我们自己设定的MyTest16了
         **/
        System.out.println(System.getProperty("java.system.class.loader"));
        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());




    }
}

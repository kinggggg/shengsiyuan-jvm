package jvm.shengsiyuan;

import jvm.shengsiyuan.bytecode.MyTest1;

public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {


        /**
         * 初次运行程序，输出为
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         * sun.misc.Launcher$AppClassLoader@135fbaa4
         *
         * 当改变扩展类加载器的加载类的路径时
         * 首先进入到classpath路径下（在本例子中为/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes）
         * 通过如下的命令将MyTest1.class打进jar包中
         *      jar cvf test.jar shengsiyuan/MyTest1.class
         * 然后通过如下的命令运行MyTest22
         *      java -Djava.ext.dirs=./ shengsiyuan.MyTest22
         * 此时程序的输出如下：
         *      sun.misc.Launcher$AppClassLoader@2a139a55
         *      sun.misc.Launcher$ExtClassLoader@3d4eac69
         * 可以看到，MyTest1此时已经由扩展类加载器进行加载了
         *
         * 这里需要注意的是，扩展类加载器只能加载存在与jar包中的class文件
         **/
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());

    }
}

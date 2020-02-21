package shengsiyuan;

/**
 * 关于命名空间的的重要说明
 *
 * 1. 子加载器所加载的类能够访问到父加载器所加载的类
 * 2. 父加载器所加载的类无法访问到子加载器所加载的类
 **/
public class MyTest17 {

    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");

        Class<?> clazz = loader1.loadClass("shengsiyuan.MySample");
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉改行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat class（不一定，原因见笔记？？笔记呢？？？）
        Object object = clazz.newInstance();
    }
}

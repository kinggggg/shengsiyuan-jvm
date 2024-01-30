package jvm.shengsiyuan;

/**
 * 关于命名空间的的重要说明
 *
 * 1. 子加载器所加载的类能够访问到父加载器所加载的类
 * 2. 父加载器所加载的类无法访问到子加载器所加载的类
 **/
public class MyTest17 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("jvm.shengsiyuan.MySample");
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat class（虽然这里没有加载。但是这种情况
        // 不是绝对的）。因为，『JVM规范允许类加载器在预料某个类将要被使用时就预先加载它』（来自有道笔记对应的PPT）
        // 可以通过增加 -XX:TraceClassLoading 参数来验证上述行为。
        Object object = clazz.newInstance();
    }
}

package shengsiyuan;

/**
 * @ClassName MyTest17
 * @Description
 * @Date 2019/4/16 10:31 PM
 * @Version v1.0
 **/
public class MyTest17 {

    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");

        Class<?> clazz = loader1.loadClass("shengsiyuan.MySample");
        System.out.println("class: " + clazz.hashCode());

        // 如果注释掉改行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会加载MyCat class（不一定，原因见笔记）
        Object object = clazz.newInstance();
    }
}

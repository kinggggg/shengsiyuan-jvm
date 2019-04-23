package shengsiyuan;

import java.lang.reflect.Method;

/**
 * @ClassName MyTest19
 * @Description 命名空间考察
 * @Author
 * @Date 2019/4/22 11:50 PM
 * @Version v1.0
 **/
public class MyTest21 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        loader1.setPath("/Users/weibo_li/Desktop/");
        loader2.setPath("/Users/weibo_li/Desktop/");

        Class<?> clazz1 = loader1.loadClass("shengsiyuan.MyPerson");
        Class<?> clazz2 = loader2.loadClass("shengsiyuan.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);

    }
}

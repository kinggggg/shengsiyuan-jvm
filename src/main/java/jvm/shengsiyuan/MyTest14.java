package jvm.shengsiyuan;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @ClassName MyTest14
 * @Description
 * @Date 2019/4/2 11:59 PM
 * @Version v1.0
 **/
public class MyTest14 {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        String resourceName = "jvm/shengsiyuan/MyParent3.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while(urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }

        System.out.println("=============");

        Class<MyTest14> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());

        System.out.println("=============");

        System.out.println(String.class.getClassLoader());

    }
}

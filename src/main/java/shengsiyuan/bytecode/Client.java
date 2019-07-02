package shengsiyuan.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        subject.request();
        System.out.println("----------------");
        subject.toString();

        System.out.println("----------------");
        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}

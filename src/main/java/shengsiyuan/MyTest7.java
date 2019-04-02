package shengsiyuan;

/**
 *
 **/
public class MyTest7 {

    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader()); //null

        Class<?> clazz2 = Class.forName("shengsiyuan.C");
        System.out.println(clazz2.getClassLoader());
    }

}

class C {

}

package shengsiyuan;

/**
 * @ClassName MyTest18
 * @Description
 * @Date 2019/4/22 11:20 PM
 * @Version v1.0
 **/
public class MyTest18_1 {

    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        loader1.setPath("/users/weibo_li/Desktop");

        Class<?> clazz = loader1.loadClass("shengsiyuan.MyTest1");

        System.out.println("class:" + clazz.hashCode());
        System.out.println("class loader:" + clazz.getClassLoader());
    }
}

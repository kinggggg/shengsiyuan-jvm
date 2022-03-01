package jvm.shengsiyuan;

/**
 * @ClassName MyTest18
 * @Description 启动类加载器，扩展类加载器和应用类加载当加载类时分别使用的目录；可以通过环境变量的形式来获取
 * @Date 2019/4/22 11:20 PM
 * @Version v1.0
 **/
public class MyTest18 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}

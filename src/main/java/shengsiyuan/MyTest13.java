package shengsiyuan;

/**
 * @ClassName MyTest13
 * @Description
 * @Date 2019/4/2 11:39 PM
 * @Version v1.0
 **/



public class MyTest13 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);

        while(null != classLoader) {
            classLoader = classLoader.getParent();

            System.out.println(classLoader);
        }

    }
}

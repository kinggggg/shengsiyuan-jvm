package shengsiyuan;

/**
 * @ClassName MyTest15
 * @Description
 * @Date 2019/4/8 10:28 PM
 * @Version v1.0
 **/
public class MyTest15 {

    public static void main(String[] args) {

        String[] strings = new String[2];
        System.out.println(strings.getClass());
        System.out.println("---------------");
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("---------------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("---------------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());

    }
}

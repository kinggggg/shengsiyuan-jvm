package jvm.shengsiyuan;

/**
 * @ClassName MyTest9
 * @Description
 * @Date 2019/4/2 10:39 PM
 * @Version v1.0
 **/

class Parent {

    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {

    static int b = 4;

    static {
        System.out.println("Child static block");
    }

}

public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {

        System.out.println(Child.b);

    }
}

package jvm.shengsiyuan;

import java.util.UUID;

/**
 * 创建一个类的实例时这个类会被初始化
 * MyParent4 myParent4 = new MyParent4();
 *
 * 对于数组实例来说，其类型是有JVM在运行期动态生成的，表示为[Lcom.zeek.jvm.shengsiyuan.MyParent4
 * 这种形式。换句话说现在创建数组对象时用的类型和数组中元素的类型不是同一个了，因此这个例子中的静态代码块没有执行。动态生成的类型，其父类型就是Object。
 *
 * 对于数组来说，JavaDoc经常讲构成的数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 *
 * 助记符：
 *      anewarray：  表示创建一个引用类型的（如类、接口、数组）数组，并将其引用值压入栈顶
 *      newarray：   表示创建一个指定的原始类型（如int、float、char等）的数组，并将其引用压入栈顶
 **/
public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());

        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());
        System.out.println("========");

        int[] ints = new int[1];
        System.out.println(ints);
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());
    }
}

class MyParent4 {
    public static final String str = UUID.randomUUID().toString() ;
    static {
        System.out.println("MyParent4 static block");
    }
}

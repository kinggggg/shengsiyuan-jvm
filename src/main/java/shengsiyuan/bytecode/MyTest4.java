package shengsiyuan.bytecode;


/*
    栈帧（stack frame）
    栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构

    栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回值以及操作数栈等信息

    符号引用，直接引用

    有些符号引用是在“类加载阶段”或是“第一次使用时”就会转换为直接引用，这种转换叫做静态解析；另外一些符号引用是在“每次运行期”
    转换为直接引用，这种转换叫做动态链接，这体现为Java的多态性

    1. invokeinterface:     调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口的哪个对象的特定方法
    2. invokestatic:        调用静态方法
    3. invokespecial:       调用自己的私有方法、构造方法(<init>)以及父类的方法
    4. invokevirtual:       调用虚方法，运行期动态查找的过程
    5. invokedynamic:       动态调用方法
 */

/*
     静态解析的4中情形：（视频中的对为什么是这四种方法的原因解释比较牵强，并且《深入理解Java虚拟机》一书中也没有为只有这四类方法符合静态解析的原因做解释性说明）
       1. 静态方法
       2. 父类方法
       3. 构造方法
       4. 私有方法

       以上4类方法称作非虚方法，他们是在类加载阶段就可以将符合引用转换为直接引用
 */
public class MyTest4 {

    public static void test() {
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }

}

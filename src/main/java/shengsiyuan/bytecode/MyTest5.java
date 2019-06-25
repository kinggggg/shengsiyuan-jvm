package shengsiyuan.bytecode;
/*
    方法的静态分派。
    Grandpa g1 = new Father()
    以上代码，g1的静态类型为Grandpa，而g1的实际类型（真正指向的类型）是Father
    我们可以得出这样的一个结论：变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化的（多条的一种），实际类型是在
    运行期方可确定。
 */
public class MyTest5 {

    // 方法重载，是一种静态的行为！
    // 即，调用重载方法的时候，只看传入参数的静态类型，而不是动态类型
    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        // 由于调用重载方法时，jvm只看参数的静态类型，而g1的静态类型为Grandpa，因此会调用public void test(Grandpa grandpa)方法
        myTest5.test(g1);
        // 同样，g2的静态类型也为Grandpa，因此也会调用public void test(Grandpa grandpa)方法
        myTest5.test(g2);
    }
}
class Grandpa {}
class Father extends Grandpa {}
class Son extends Father {}

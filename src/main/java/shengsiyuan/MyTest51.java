package shengsiyuan;

/**
 *
 **/
public class MyTest51 {
    public static void main(String[] args) {
        System.out.println(MyParent52.thread);
    }
}

//考察1
/*interface MyParent51 {
    public static Thread thread = new Thread() {

        {
            System.out.println("MyParent51 invoked");
        }
    };
}

interface MyChild51 extends MyParent51 {
    public static int b = 6;
}*/

//考察2
/*interface MyParent51 {
    public static Thread thread = new Thread() {

        {
            System.out.println("MyParent51 invoked");
        }
    };
}

class MyChild51 implements MyParent51 {
    public static final int b = 6; //多了final
}*/

//考察3
/*
interface MyParent51 {
    public static Thread thread = new Thread() {

        {
            System.out.println("MyParent51 invoked");
        }
    };
}

class MyChild51 implements MyParent51 {
    public static int b = 6;
}*/

interface MyGrandpa51 {

    public static Thread thread = new Thread() {

        {
            System.out.println("MyGrandpa51 invoked");
        }
    };

}

interface MyParent52 extends MyGrandpa51{

    public static Thread thread = new Thread() {

        {
            System.out.println("MyParent52 invoked");
        }
    };

}

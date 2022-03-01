package jvm.shengsiyuan;

/**
 * @ClassName JavaTest
 * @Description
 * @Author liweibo
 * @Date 2020/3/1 8:54 PM
 * @Version v1.0
 **/
public class JavaTest {

    int a ;

    public static void main(String[] args) {

//        int a;
//        System.out.println(a);

        System.out.println(new JavaTest().getA());

    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

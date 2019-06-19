package shengsiyuan.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/*
    对于Java类中的每一个实例方法（非static方法），其在编译后所生成的字节码当中，方法参数的数量总是会比源代码中方法
    参数的数量多一个（this），它位于方法的第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来去访问当前
    对象的属性以及方法

    这个操作是在编译器完成的，即由javac编译器在编译的时候将对this的访问转化为对一个普通实例方法参数的访问；接下来运行期间，
    由JVM在调用实例方法时，自动向实例方法传入该this参数。所以，在实例方法的局部变量表中，至少会有一个当前对象的局部变量
 */
public class MyTest3 {

    public void test() {
        try {
            InputStream in = new FileInputStream("test.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
        }catch (FileNotFoundException ex) {

        }catch (IOException ex) {

        }catch (Exception ex) {

        }finally {
            System.out.println("finally");
        }
    }
}

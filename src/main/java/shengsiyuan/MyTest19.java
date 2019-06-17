package shengsiyuan;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @ClassName MyTest19
 * @Description
 * @Author
 * @Date 2019/4/22 11:50 PM
 * @Version v1.0
 **/
public class MyTest19 {

    public static void main(String[] args) {

        //AESKeyGenerator 位于扩展类加载器所加载的类路径下，因此AESKeyGenerator是由扩展类类加载器进行加载
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        //MyTest19位于系统类加载器所加载的类路径下，因此MyTest19是由系统类加载器进行加载
        System.out.println(MyTest19.class.getClassLoader());

    }
}

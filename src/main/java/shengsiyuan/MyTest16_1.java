package shengsiyuan;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName MyTest16
 * @Description 这是自己的自定义的类加载器，正确使用了loadClassData方法
 * @Date 2019/4/9 10:36 PM
 * @Version v1.0
 **/
public class MyTest16_1 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class" ;

    public MyTest16_1(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_1(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]" ;
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;


        try {

            is = new FileInputStream(new File("/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes/shengsiyuan/MyTest1.class"));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    public static void main(String[] args) throws Exception {
        MyTest16_1 myTest16 = new MyTest16_1("loader1");

        Class clazz = myTest16.findClass("shengsiyuan.MyTest1");
        System.out.println(clazz.newInstance());
    }
}

package shengsiyuan;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName MyTest16
 * @Description 这是视频中的实例程序，貌似根本就没有调用到loadClassData方法。视频讲解是错误的
 * @Date 2019/4/9 10:36 PM
 * @Version v1.0
 **/
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class" ;

    public MyTest16(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);

    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;


        try {

            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch;

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

    public static void main(String[] args) throws Exception {
        MyTest16 myTest16 = new MyTest16("loader1");

        test(myTest16);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("shengsiyuan.MyTest1");
        Object object = clazz.newInstance();

        System.out.println(object);
    }
}
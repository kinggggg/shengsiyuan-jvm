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

    private String path;

    private final String fileExtension = ".class" ;

    public MyTest16(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {

        System.out.println("findClass invoke: " + className);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);

    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", "/");

        try {

            is = new FileInputStream(new File(this.path + className + this.fileExtension));
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
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes");
        loader1.setPath("/Users/weibo_li/Desktop/");

        Class<?> clazz = loader1.loadClass("shengsiyuan.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println(clazz.getClassLoader());
    }

}

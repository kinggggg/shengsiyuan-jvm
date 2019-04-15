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
public class MyTest16_2 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class" ;

    public MyTest16_2(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_2(ClassLoader parent, String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 按照ClassLoader类中loadClass方法的说明：建议自定义的类加载器重写findClass方法
     **/
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

    /**
     * 当删除掉classpath下的MyTest1 class文件时，MyTest1加载了两次，但是根据以往的经验：一个类只加载一次，但是通过这个例子看到一个类加载了两次？！这是为什么呢？这涉及到了命名空间的概念
     **/
    public static void main(String[] args) throws Exception {
        MyTest16_2 loader1 = new MyTest16_2("loader1");
        //当在项目的classpath中存在MyTest1的class文件时，由loader1的父加载器即系统类加载器AppClassLoader进行加载（双亲委派模型的定义：当加载一个类时优先由其父加载器进行加载）
//        loader1.setPath("/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes");
        //当在项目的classpath中不存在MyTest1的class文件时，由于父加载器AppClassLoader无法加载MyTest1，于是由loader1自己进行加载
        loader1.setPath("/Users/weibo_li/Desktop/");

        Class<?> clazz = loader1.loadClass("shengsiyuan.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());

        System.out.println("---------------------");

        MyTest16_2 loader2 = new MyTest16_2(loader1, "loader2");
        loader2.setPath("/Users/weibo_li/Desktop/");
        Class<?> clazz2 = loader2.loadClass("shengsiyuan.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);
        System.out.println(clazz2.getClassLoader());

        System.out.println("---------------------");

        MyTest16_2 loader3 = new MyTest16_2("loader3");
        loader3.setPath("/Users/weibo_li/Desktop/");
        Class<?> clazz3 = loader3.loadClass("shengsiyuan.MyTest1");
        System.out.println("class: " + clazz3.hashCode());
        Object object3 = clazz2.newInstance();
        System.out.println(object3);
        System.out.println(clazz3.getClassLoader());
    }

}

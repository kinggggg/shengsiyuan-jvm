package jvm.shengsiyuan;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName MyTest16
 * @Description
 *
 * 程序的效果如下：
 * 1. 当MyTest1.class存在类路径（即，classpath中时，此时为(/Users/weibo_li/Documents/code/shengsiyuan-jvm/build/classes/java/main/shengsiyuan/MyTest1.class，这个
 * 路径与IDEA的不同而不同，在旧版本，例如2018版本中的路径为/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes）中时
 * 运行下面的程序的输出如下。可以看到加载MyTest1的均是系统类加载器AppClassLoader，因为系统类加载器AppClassLoader可以同类路径下加载MyTest1
 *
 * class: 2018699554
 * shengsiyuan.MyTest1@4e25154f
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * ---------------------
 * class: 2018699554
 * shengsiyuan.MyTest1@70dea4e
 * sun.misc.Launcher$AppClassLoader@2a139a55
 *
 *
 * 2. 当MyTest1.class在类路径下不存在时
 *  运行下面的程序输出如下。可以看到虽然加载的class文件是同一份，但是是由不同的类加载进行加载的
 *
 * findClass invoke: shengsiyuan.MyTest1
 * class loader name: loader1
 * class: 792791759
 * shengsiyuan.MyTest1@47089e5f
 * shengsiyuan.MyTest16@43556938
 * ---------------------
 * findClass invoke: shengsiyuan.MyTest1
 * class loader name: loader2
 * class: 1330106945
 * shengsiyuan.MyTest1@4c3e4790
 * shengsiyuan.MyTest16@43556938
 *
 *
 *
 *
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

    public MyTest16(ClassLoader parent){
        super(parent);
    }

    public MyTest16(ClassLoader parent, String classLoaderName){
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
        MyTest16 loader1 = new MyTest16("loader1");
        //当在项目的classpath中存在MyTest1的class文件时，由loader1的父加载器即系统类加载器AppClassLoader进行加载（双亲委派模型的定义：当加载一个类时优先由其父加载器进行加载）
//        loader1.setPath("/Users/weibo_li/Documents/code/shengsiyuan-jvm/out/production/classes");
        //当在项目的classpath中不存在MyTest1的class文件时，由于父加载器AppClassLoader无法加载MyTest1，于是由loader1自己进行加载
        loader1.setPath("/Users/weibo_li/Desktop/");
//        loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

        Class<?> clazz = loader1.loadClass("jvm.shengsiyuan.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(clazz.getClassLoader());

        System.out.println("---------------------");

        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("/Users/weibo_li/Desktop/");
//        loader2.setPath("C:\\Users\\Administrator\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("jvm.shengsiyuan.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);
        System.out.println(clazz.getClassLoader());
    }

}

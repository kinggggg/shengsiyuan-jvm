package java.lang;

/**
 * 运行下面的程序会出错，异常信息如下：
 * Error: A JNI error has occurred, please check your installation and try again
    Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
        at java.lang.ClassLoader.preDefineClass(ClassLoader.java:662)
        at java.lang.ClassLoader.defineClass(ClassLoader.java:761)
        at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:142)
        at java.net.URLClassLoader.defineClass(URLClassLoader.java:467)
        at java.net.URLClassLoader.access$100(URLClassLoader.java:73)
        at java.net.URLClassLoader$1.run(URLClassLoader.java:368)
        at java.net.URLClassLoader$1.run(URLClassLoader.java:362)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:361)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        at sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:495)

    当把包的名称修改为只要组合不是java.lang后就能执行成功！这是为什么呢？
 */
public class Vvvv {
    public static void main(String[] args) {
        System.out.println("aaa");
    }
}

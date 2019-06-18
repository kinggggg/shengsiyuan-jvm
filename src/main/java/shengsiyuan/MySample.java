package shengsiyuan;

/**
 * @ClassName MySample
 * @Description
 * @Date 2019/4/16 10:28 PM
 * @Version v1.0
 **/
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by : " + this.getClass().getClassLoader());

        new MyCat();
    }
}

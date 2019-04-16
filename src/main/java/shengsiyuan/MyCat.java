package shengsiyuan;

/**
 * @ClassName MyCat
 * @Description
 * @Date 2019/4/16 10:27 PM
 * @Version v1.0
 **/
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by : " + this.getClass().getClassLoader());
    }

}

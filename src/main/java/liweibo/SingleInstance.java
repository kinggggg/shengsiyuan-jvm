package liweibo;

/**
 * 单例模式
 */
public class SingleInstance {

    private static volatile SingleInstance singleInstance;

    private SingleInstance(){

    }

    public static SingleInstance getInstance() {
        if(singleInstance == null) {
            synchronized(SingleInstance.class) {
                if(singleInstance == null) {
                    singleInstance = new SingleInstance();
                    return singleInstance;
                }else {
                    return singleInstance;
                }
            }
        }else {
            return singleInstance;
        }
    }
}

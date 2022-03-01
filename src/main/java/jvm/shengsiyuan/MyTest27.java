package jvm.shengsiyuan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @ClassName MyTest27
 * @Description
 * @Date 2019/5/22 11:42 PM
 * @Version v1.0
 **/
public class MyTest27 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "passowrd");

    }
}

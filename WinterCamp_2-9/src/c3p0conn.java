import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class c3p0conn {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    public static Connection getConnection(){
        Connection conn = null;
        try{
            //获取连接
            conn = ds.getConnection();
            System.out.println("连接成功！！");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  conn;
    }
    //关闭资源
    public static  void closeConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

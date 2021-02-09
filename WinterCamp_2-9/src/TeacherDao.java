import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class TeacherDao {
    private Connection conn = null;

    private QueryRunner qr = new QueryRunner();

    public List<Teacher> SelectAll(){
        List<Teacher> List = null;
        //获取连接
        conn = c3p0conn.getConnection();
        //sql语句
        String sql = "select * from teacher";
        try {
            List = qr.query(conn,sql,new BeanListHandler<Teacher>(Teacher.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            c3p0conn.closeConnection(conn);
        }
        return List;
    }

    /*条件查询*/
    public Teacher SelectAll2(int id,String tname){
        Teacher tea = null;
        conn = c3p0conn.getConnection();
        String sql = "SELECT * FROM teacher where id = ? and tname = ?";
        try {
            tea = qr.query(conn,sql,new BeanHandler<Teacher>(Teacher.class),id,tname);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return tea;
    }
    //增加
    public int Insert(Teacher st){
        int i = 0;
        conn = c3p0conn.getConnection();
        String sql = "insert into teacher(id,tname,class) values(?,?,?)";
        try {
            i = qr.update(conn,sql,st.getId(),st.getName(),st.gettclass());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return i;
    }

    //删除
    public int deleteConn(int id){
        int i=0;
        conn = c3p0conn.getConnection();
        String sql = "DELETE FROM teacher WHERE id = ?";
        //System.out.println("---------------------");
        try {
            i = qr.update(conn,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return i;
    }

    //修改
    public int updateConn(Teacher tea){
        int i=0;
        conn = c3p0conn.getConnection();
        String sql = "update teacher set tname=?,class=? where id = ?";
        try {
            i = qr.update(conn,sql,tea.getName(),tea.gettclass(),tea.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return i;
    }


}

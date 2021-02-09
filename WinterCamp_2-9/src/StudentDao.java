import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class StudentDao {
    private Connection conn = null;

    private QueryRunner qr = new QueryRunner();
    //查询所有学生
    public List<Student> SelectAll(){
        List<Student> List = null;
        //获取连接
        conn = c3p0conn.getConnection();
        //sql语句
        String sql = "select * from student";
        try {
            List = qr.query(conn,sql,new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            c3p0conn.closeConnection(conn);
        }
        return List;
    }

    /*条件查询*/
    public Student SelectAll2(int id,String sname){
        Student stu = null;
        conn = c3p0conn.getConnection();
        String sql = "SELECT * FROM student where id = ? and sname = ?";
        try {
            stu = qr.query(conn,sql,new BeanHandler<Student>(Student.class),id,sname);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return stu;
    }
    //增加
    public int Insert(Student st){
        int i = 0;
        conn = c3p0conn.getConnection();
        String sql = "insert into student(id,sname,sex) values(?,?,?)";
        try {
            i = qr.update(conn,sql,st.getId(),st.getName(),st.getSex());
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
        String sql = "DELETE FROM student WHERE id = ?";
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
    public int updateConn(Student stu){
        int i=0;
        conn = c3p0conn.getConnection();
        String sql = "update student set sname=?,sex=? where id = ?";
        try {
            i = qr.update(conn,sql,stu.getName(),stu.getSex(),stu.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return i;
    }
    //事务
    public int G(int id) {
        int i=0;
        conn = c3p0conn.getConnection();
        String sql = "DELETE FROM student WHERE id = ?";
        try {
            i = qr.update(conn,sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            c3p0conn.closeConnection(conn);
        }
        return i;
    }

}

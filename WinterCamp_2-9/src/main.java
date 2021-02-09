public class main {
    public static void main(String[] args) {
        StudentDao sd = new StudentDao();
        TeacherDao td = new TeacherDao();
        td.Insert(new Teacher(1,"李白","3"));
        Student stu1 = sd.SelectAll2(3,"王五");
        System.out.println(stu1);
        stu1.setName("测试");
        int i = sd.updateConn(stu1);
        System.out.println(i);
        sd.G(1);
        sd.deleteConn(4);


    }
}

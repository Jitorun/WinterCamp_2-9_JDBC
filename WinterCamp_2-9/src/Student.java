public class Student {
    private int id;
    private String sname;
    private String sex;
    public Student() {
    }

    public Student(int id,String sname ,String sex){
        this.id = id;
        this.sname = sname;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return sname;
    }

    public void setName(String name) {
        this.sname = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                '}'+"\n";
    }
}

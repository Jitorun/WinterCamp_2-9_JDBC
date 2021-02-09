public class Teacher {
    private int id;
    private String tname;
    private String tclass;
    public Teacher() {
    }

    public Teacher(int id,String sname ,String tclass){
        this.id = id;
        this.tname = sname;
        this.tclass = tclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return tname;
    }

    public void setName(String name) {
        this.tname = name;
    }

    public String gettclass() {
        return tclass;
    }

    public void settclass(String tclass) {
        this.tclass = tclass;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + tname + '\'' +
                ", class='" + tclass + '\'' +
                '}'+"\n";
    }
}

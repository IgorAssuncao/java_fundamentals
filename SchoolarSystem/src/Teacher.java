import java.util.LinkedList;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String[] courses;

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public Teacher(int teacherId, String teacherName, String[] courses) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.courses = courses;
    }

    public int getId() {
        return teacherId;
    }

    public void setId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
}

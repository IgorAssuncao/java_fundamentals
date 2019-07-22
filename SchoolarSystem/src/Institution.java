public class Institution {
    private Class[] classes;
    private Teacher[] teachers;
    private Student[] students;
    private int studentsQuantity;

    public Class[] getclasses() {
        return classes;
    }

    public void setClasses(Class[] classes) {
        this.classes = classes;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public int getLastStudentId(Student[] students) {
        int lastStudentId = 0;
        for (int index = 0; index < students.length; index++) {
            lastStudentId = students[index].getId();
        }
        return lastStudentId;
    }

    public boolean insertStudentIntoInstitution(Student student) {
        for (int index = 0; index < studentsQuantity; index++) {
            if (student.getId() == students[index].getId()) {
                System.out.println("Student already exists!");
                return false;
            }
        }
        students[this.getStudentsQuantity()] = student;
        this.setStudentsQuantity(this.getStudentsQuantity() + 1);
        return true;
    }
}

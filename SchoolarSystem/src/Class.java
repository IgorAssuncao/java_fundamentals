public class Class {
    private int classId;
    private int courseName;
    private int studentsCapacity;
    private int studentsQuantity;
    private Teacher teacher;
    private Student[] students;

    public Class(int classId, int courseName, int studentsCapacity) {
        this.classId = classId;
        this.courseName = courseName;
        this.studentsCapacity = studentsCapacity;
    }

    public int getClassId() {
        return classId;
    }

    public int getCourseName() {
        return courseName;
    }

    public int getStudentsCapacity() {
        return studentsCapacity;
    }

    public int getStudentsQuantity() {
        return studentsQuantity;
    }

    public void setStudentsQuantity(int studentsQuantity) {
        this.studentsQuantity = studentsQuantity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public boolean isCourseFull(Class classAux) {
        return classAux.getStudentsQuantity() < classAux.getStudentsCapacity();
    }

    public boolean checkTeacher() {
        return this.getTeacher() != null;
    }

    public boolean insertStudentIntoClass(Student student) {
        for (int index = 0; index < this.getStudentsQuantity(); index++) {
            if (student.getId() == students[index].getId()) {
                System.out.println("Invalid studentId");
                return false;
            }
        }
        students[this.getStudentsQuantity()] = student;
        this.setStudentsQuantity(this.getStudentsQuantity() + 1);
        return true;
    }

    public boolean removeStudentIntoClass(Student student) {
        for (int index = 0; index < this.getStudentsQuantity(); index++) {
            if (student.getId() == students[index].getId()) {
                students[index] = null;
                this.setStudentsQuantity(this.getStudentsQuantity() - 1);
                return true;
            }
        }
        return false;
    }
}

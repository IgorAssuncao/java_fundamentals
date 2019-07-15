public class Student {
    private String name;
    private int grade1;
    private int grade2;

    public Student() {
    }

    public Student(String name, int grade1, int grade2) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    @Override
    public String toString() {
        return String.format("Student: {Name: %s, Grade1: %d, Grade2: %d}", name, grade1, grade2);
    }
}

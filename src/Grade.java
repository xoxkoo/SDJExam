public class Grade {
    private int grade;
    private  Course course;

    public Grade(int grade, Course course) {
        this.grade = grade;
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }
    public Course getCourse() {
        return course;
    }

    public Grade copy() {
        return new Grade(this.grade, this.course);
    }

    public String toString() {
        return "Course: " + course + ", grade: " + grade;
    }
}

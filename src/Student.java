import java.util.ArrayList;

public class Student {
    private int studentNumber;
    private String name;
    private CoronaPassport coronaPassport;
    private ArrayList<Course> courses;
    private ArrayList<Grade> grades;

    public Student(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;

        this.courses = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addGrade(int grade, Course course) {
        for (Course studentCourse: courses) {
            if (course.getName().equals(studentCourse.getName()))
                grades.add(new Grade(grade, course));
        }
    }

    public void addCoronaPassport(CoronaPassport passport) {
        this.coronaPassport = passport;
    }
    public void removeCoronaPassport() {
        this.coronaPassport = null;
    }
    public CoronaPassport getCoronaPassport() {
        return coronaPassport;
    }

    public boolean hasValidCoronnaPassport() {
        Date date = coronaPassport.getDate();
        if (! date.isBefore(date.today()))
            return false;
        else if (coronaPassport.getReason() == "Vaccinated")
            return true;
        else if (coronaPassport.getReason() == "Tested" && date.numberOfDaysUntil(date.today()) <=  3)
            return true;
        else if (coronaPassport.getReason() == "Infected" && date.numberOfDaysUntil(date.today()) > 14 && date.numberOfDaysUntil(date.today()) < 180)
            return true;
        else
            return false;
    }

    public double getGradeAverage() {
        int sum = 0;
        double i = 0;

        for (Grade grade : grades) {
            sum += grade.getGrade();
            i++;
        }
        System.out.println(sum);

        return sum / i;
    }

    public Grade[] getAllGrades() {
        Grade[] gradesA = new Grade[grades.size()];

        for (int i = 0; i < grades.size(); i++) {
            gradesA[i] = grades.get(i);
        }
        return gradesA;
    }

    public Course[] getAllCourses() {
        Course[] coursesA = new Course[courses.size()];

        for (int i = 0; i < courses.size(); i++) {
            coursesA[i] = courses.get(i);
        }
        return coursesA;
    }
}

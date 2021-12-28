import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Date date = new Date(13,12, 2021);
        Date date2 = new Date(15,1, 2022);

        Time time1 = new Time(9, 25, 00);
        Time time2 = new Time(15, 25, 00);

        Resource resource1 = new Resource("res", "pdf");

        ArrayList<Resource> list = new ArrayList<>();
        list.add(resource1);

        Lesson lesson = new Lesson("asdasd", date, time1, time2, list);

        System.out.println(lesson);

        Student student = new Student(315184, "Anton Durcak");

        student.addCoronaPassport(new CoronaPassport("Infected", date));
        student.addCourse(new Course("SDJ"));
        student.addGrade(1, new Course("SDJ"));
        student.addGrade(3, new Course("SDJ"));
        student.addGrade(2, new Course("SDJ"));

        System.out.println(student.getGradeAverage());
    }
}

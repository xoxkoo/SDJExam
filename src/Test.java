import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Date date = new Date(26,12, 2021);
        Date date2 = new Date(15,1, 2022);

        Time time1 = new Time(9, 25, 00);
        Time time2 = new Time(15, 25, 00);

        Resource resource1 = new Resource("res", "pdf");

        ArrayList<Resource> list = new ArrayList<>();
        list.add(resource1);

        Lesson lesson = new Lesson("asdasd", date, time1, time2, list);

        System.out.println(lesson);
    }
}

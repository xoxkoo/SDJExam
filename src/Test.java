public class Test {
    public static void main(String[] args) {

        Time time1 = new Time(10, 20,10);
        Time time2 = new Time(11, 25,00);
        System.out.println(time1.timeUntil(time2));
    }
}

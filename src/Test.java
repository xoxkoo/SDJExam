public class Test {
    public static void main(String[] args) {
        Date date = new Date(26,12, 2021);
        Date date2 = new Date(15,1, 2022);

        System.out.println(date.numberOfDaysUntil(date2));
        date.today();
    }
}

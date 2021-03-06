import java.util.GregorianCalendar;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isBefore(Date date) {
        if (year < date.year)
            return true;
        else if (year == date.year && month < date.month)
            return true;
        else if (month == date.month && day < date.day)
            return true;
        else
            return false;
    }

    public boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int daysInMonth() {
        int[] s = {4, 6, 9, 11};

        if (month == 2) {
            if (isLeapYear()) return 29;
            else return 28;
        }
        else {
            for (int m: s) {
                if (m == month) return 30;
            }
        }
        return 31;
    }

    public void nextDay() {
        if (day == daysInMonth()) {
            day = 1;
            month++;
            if (month - 1 == 12) {
                year++;
                month = 1;
            }
        }
        else
            day++;
    }

    public int numberOfDaysUntil(Date date2) {
        Date dateCopy = copy();
        if (dateCopy.isBefore(date2)) {
            int i = 0;
            while (! date2.equals(dateCopy)) {
                dateCopy.nextDay();
                i++;
            }
            return i;
        }
        else
            return -1;
    }

    public static Date today() {
        GregorianCalendar currentDate = new GregorianCalendar();
        return new Date(currentDate.get(GregorianCalendar.DATE), currentDate.get(GregorianCalendar.MONTH) + 1, currentDate.get(GregorianCalendar.YEAR));
    }

    public Date copy() {
        return new Date(day, month, year);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        return day == date.day && month == date.month && year == date.year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

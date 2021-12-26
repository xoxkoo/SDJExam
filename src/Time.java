public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
    }

    public Time(int totalTimeInSeconds) {

    }

    public int convertToSeconds() {
        return 1;
    }

    public boolean isBefore(Time time) {
        if (hour < time.hour)
            return true;
        else if (hour == time.hour && minute < time.minute)
            return true;
        else if (minute == time.minute && second < time.second)
            return true;
        else
            return false;
    }

    public Time timeUntil(Time time) {
        if (isBefore(time))
            return new Time(hour - time.hour, time.minute, this.second);
        else
            return new Time(0,0,0);
    }

    public Time copy() {
        return new Time(hour, minute, second);
    }

    public boolean equals(Object obj) {
        if (! (obj instanceof Time))
            return false;

        Time time = (Time) obj;

        return hour == time.hour && minute == time.minute && second == time.second;
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}

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

        hour = totalTimeInSeconds / 3600;
        minute = totalTimeInSeconds % 3600 / 60;
        second = totalTimeInSeconds % 3600 % 60;
    }

    public int convertToSeconds() {
        return (hour * 3600) + (minute * 60) + second;
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
        if (isBefore(time)) {
            int hUntil = time.hour - hour;
            int mUntil = 0;
            int sUntil = 0;

            if (time.minute < minute)
                mUntil = 60 - minute + time.minute;
            else
                mUntil = time.minute - minute;

            if (time.second < second)
                sUntil = 60 - second + time.second;
            else
                sUntil = time.second - second;

            return new Time(hUntil, mUntil, sUntil);
        }
        else
            return null;
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

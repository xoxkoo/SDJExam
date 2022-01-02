import java.util.ArrayList;

public class Lesson {
    private String topic;
    private Date date;
    private ArrayList<Resource> resources;
    private Time start;
    private Time end;

    public Lesson(String topic, Date date, Time start, Time end, ArrayList<Resource> resources) {
        if (hasValidTime(start, end)) {
            this.topic = topic;
            this.date = date.copy();
            this.start = start.copy();
            this.end = end.copy();
            this.resources = resources;
        }
        else {
            this.topic = null;
            this.date = null;
            this.start = null;
            this.end = null;
            this.resources = null;
        }
    }

    public String getTopic() {
        return topic;
    }
    public Date getDate() {
        return date.copy();
    }
    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Resource> getAllPDFs() {
        ArrayList<Resource> pdfs = new ArrayList<>();
        for (Resource res : resources) {
            if (res.isPDF())
                pdfs.add(res);
        }
        return pdfs;
    }

    public Time getDuration() {
        return start.timeUntil(end);
    }

    public static boolean hasValidTime(Time startTime, Time endTime) {
        if (! startTime.isBefore(endTime))
            return false;
        else if (startTime.isBefore(new Time(8,20,00)))
            return false;
        else if (endTime.timeUntil(new Time(21,10,00)) == null)
            return false;
        else
            return true;
    }

    public String getDateTimeString() {
        return date.toString() + " " + start.toString() + " " + end.toString();
    }

    public boolean equals(Object obj) {
        if (! (obj instanceof Lesson))
            return false;

        Lesson other = (Lesson) obj;

        return topic.equals(other.topic) &&
                date.equals(other.date) &&
                start.equals(other.start) &&
                end.equals(other.end) &&
                resources.equals(other.resources);
    }

    public String toString() {
        String str = "Topic: " + topic + ", " + getDateTimeString() + ", ";
        if (resources.size() == 0)
            str += "no resources";
        else {
            str += "resources: ";
            for (Resource res : resources) {
                str += res.toString() + ", ";
            }
        }
        return str;
    }
}

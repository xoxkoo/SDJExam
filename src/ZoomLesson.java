import java.util.ArrayList;

public class ZoomLesson extends OnlineLesson{
    private String link;
    private boolean breakoutRooms;

    public ZoomLesson(String topic, Date date, Time start, Time end, ArrayList<Resource> resources, boolean camera, String link, boolean breakout) {
        super(topic, date, start, end, resources, camera);
        this.link = link;
        this.breakoutRooms = breakout;
    }

    public String getLink() {
        return link;
    }

    public boolean usesBreakoutRooms() {
        return breakoutRooms;
    }

     public String nameOfTheSoftware() {
        return "Zoom";
     }

     public boolean equals(Object obj) {
        if (! (obj instanceof ZoomLesson))
            return false;

        ZoomLesson other = (ZoomLesson) obj;
        return super.equals(other) && link.equals(other.getLink()) && breakoutRooms == other.breakoutRooms;
     }

    public String toString() {
        return super.toString() + ", link: " + link + ((usesBreakoutRooms()) ? ", uses breakout rooms" : "");
    }
}

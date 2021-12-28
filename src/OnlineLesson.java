import java.util.ArrayList;

public abstract class OnlineLesson extends Lesson {
    private boolean cameraRequired;

    public OnlineLesson(String topic, Date date, Time start, Time end, ArrayList<Resource> resources, boolean camera) {
        super(topic, date, start, end, resources);
        this.cameraRequired = camera;
    }

    public boolean isCameraRequired() {
        return cameraRequired;
    }

    public abstract String nameOfTheSoftware();

    public boolean equals(Object obj) {
        if (! (obj instanceof OnlineLesson))
            return false;

        OnlineLesson other = (OnlineLesson) obj;

        return false;
    }

    public String toString() {
        return super.toString() + nameOfTheSoftware() + ((cameraRequired) ? ", camera is required" : "");
    }
}

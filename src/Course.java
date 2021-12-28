import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Lesson> schedule;

    public Course(String name) {
        this.name = name;
        this.schedule = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfLessons() {
        return this.schedule.size();
    }

    public void addLesson(Lesson lesson) {
        schedule.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        schedule.remove(lesson);
    }

    public boolean hasLessonOnDate(Date date) {
        for (Lesson lesson : schedule) {
            if (lesson.getDate() == date)
                return true;
        }
        return false;
    }

    public ArrayList<Lesson> getAllLessons() {
        return schedule;
    }

    public ArrayList<String> getAllTopics() {
        ArrayList<String> topics = new ArrayList<>();

        for (Lesson lesson : schedule) {
            topics.add(lesson.getTopic());
        }

        return topics;
    }

    public ArrayList<OnlineLesson> getOnlineLesson() {
        ArrayList<OnlineLesson> lessons = new ArrayList<>();

        for (Lesson lesson : schedule) {

        }

        return lessons;
    }

    public ArrayList<Resource> getAllResources() {
        ArrayList<Resource> resources = new ArrayList<>();

        for (Lesson lesson : schedule) {
            for (Resource resource : lesson.getResources()) {
                resources.add(resource);
            }
        }

        return resources;
    }

    public String toString() {
        String str = "Name: " + name;

        for (Lesson lesson : schedule) {
            str += lesson.toString();
        }

        return str;
    }
}

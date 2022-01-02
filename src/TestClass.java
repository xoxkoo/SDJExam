import java.io.PrintStream;
import java.util.ArrayList;

public class TestClass
{

    public static void main(String[] args)
    {
        WriteHelper.setCorrectPrintStream();

        //region Resources
        writeTitle("Resources");

        Resource resource1 = new Resource("abc", "docx");
        Resource resource2 = new Resource("project", "pdf");

        System.out.println(resource1);
        System.out.println("Is PDF:" + resource1.isPDF());
        System.out.println(resource2);
        System.out.println("Is PDF:" + resource2.isPDF());

        //endregion
        //region Time
        writeTitle("Time");

        Time time1 = new Time(12, 2, 20);
        Time time2 = new Time(time1.convertToSeconds());
        Time time3 = new Time(14, 59, 59);
        Time time4 = time1.timeUntil(time3);

        System.out.println(time1);
        System.out.println("Seconds: " + time1.convertToSeconds());
        System.out.println("New Time from previous: " + time2);
        System.out.println("Is " + time1 + " before " + time3 + ": " + time1.isBefore(time3));
        System.out.println("Is " + time3 + " before " + time1 + ": " + time3.isBefore(time1));
        System.out.println("Time until: " + time4);

        //endregion
        //region Date
        writeTitle("Date");

        Date date1 = new Date(20, 2, 2021);
        Date date2 = new Date(25, 12, 2021);
        int daysUntil = date1.numberOfDaysUntil(date2);
        Date today = Date.today();

        System.out.println(date1 + " is before " + date2 + ": " + date1.isBefore(date2));
        System.out.println(date2 + " is before " + date1 + ": " + date2.isBefore(date1));
        System.out.println("Days until: " + daysUntil);
        System.out.println("Today: " + today);

        //endregion
        //region Lesson
        writeTitle("Lesson");

        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);

        Time timeEarly = new Time(7, 30, 0);
        Time timeGood = new Time(8, 20, 0);
        Time timeLate = new Time(21, 40, 0);
        Lesson lesson1 = createLesson(time1, time3);
        Lesson lesson2 = createLesson(timeGood, time1);
        Lesson lessonWrong1 = createLesson(timeEarly, time1);
        Lesson lessonWrong2 = createLesson(time1, timeLate);
        Lesson lessonWrong3 = createLesson(time3, time1);
        DiscordLesson discordLesson = new DiscordLesson("habla", today, time1, time3, resources, false, "Banana");
        ZoomLesson zoomLesson = new ZoomLesson("habla", today, time1, time3, resources, true, "Banana", true);

        System.out.println(lesson1);
        System.out.println("Duration: " + lesson1.getDuration());
        System.out.println(lesson2);
        System.out.println();
        System.out.println("Wrong: " + lessonWrong1);
        System.out.println("Wrong: " + lessonWrong2);
        System.out.println("Wrong: " + lessonWrong3);
        System.out.println(discordLesson);
        System.out.println("Channel name: " + discordLesson.getChannelName());
        System.out.println(zoomLesson);
        System.out.println("PDF count: " + zoomLesson.getAllPDFs().size());
        System.out.println("PFF Resource: " + zoomLesson.getAllPDFs());
        System.out.println("Link: " + zoomLesson.getLink());

        //endregion
        //region Corona pass
        writeTitle("CoronaPass");

        CoronaPassport passport = createCoronaPass("Vaccinated");
        createCoronaPass("Anti-Vax");
        System.out.println(passport);

        //endregion
        //region Course
        writeTitle("Course");

        Course course = new Course("Java Pain Course");
        course.addLesson(lesson1);
        course.addLesson(lesson2);
        course.addLesson(discordLesson);
        course.addLesson(zoomLesson);
        System.out.println("Number of lessons: " + course.getNumberOfLessons());
        course.removeLesson(lesson1);
        System.out.println("Number of lessons after removing one: " + course.getNumberOfLessons());
        course.addLesson(lesson1);
        System.out.println("Has lesson today (should be true): " + course.hasLessonOnDate(Date.today()));
        System.out.println("Has lesson on another day (should be false): " + course.hasLessonOnDate(new Date(4, 4, 2021)));
        System.out.println();
        System.out.println("All lessons");
        writeLessonList(course.getAllLessons());
        System.out.println("Online lessons");
        writeLessonList(course.getOnlineLessons());
        System.out.println("Camera lessons");
        writeLessonList(course.getOnlineLessonsWithCameraRequired());
        System.out.println("Discord Lessons");
        writeLessonList(course.getDiscordLessons());
        System.out.println("Zoom Breakout Lessons");
        writeLessonList(course.getZoomLessonsWithBreakoutRooms());
        System.out.println("All topics: " + String.join(", ", course.getAllTopics()));
        System.out.println();
        System.out.println("All Resources: ");
        course.getAllResources().forEach(System.out::println);

        //endregion
        //region Grade
        writeTitle("Grade");

        Grade grade = new Grade(2, course);
        System.out.println("Grade: " + grade);

        //endregion
        //region Student
        writeTitle("Student");

        Student student = new Student(315279, "Greg");
        student.addCourse(course);
        student.addGrade(4, course);
        //Vaccinated valid
        CoronaPassport validPassVax = new CoronaPassport("Vaccinated", new Date(5, 10, 2020));
        //Tested in the last 3 days
        CoronaPassport validPassTested = new CoronaPassport("Tested", new Date(20, 12, 2021));
        //Infected more than 14 days ago and less than a year ago
        CoronaPassport validPassInfected = new CoronaPassport("Infected", new Date(18, 11, 2021));
        //Tested more than 3 days ago
        CoronaPassport invalidPassTested1 = new CoronaPassport("Tested", new Date(17, 12, 2021));
        //Tested pass issues in the future?
        CoronaPassport invalidPassTested2 = new CoronaPassport("Tested", new Date(22, 12, 2021));
        //Infected in the last 14 days
        CoronaPassport invalidInfected1 = new CoronaPassport("Infected", new Date(16, 12, 2021));
        //Infected more than 6 month ago
        CoronaPassport invalidInfected2 = new CoronaPassport("Infected", new Date(5, 4, 2021));

        System.out.println("Student name: " + student.getName() + " (" + student.getStudentNumber() + ")");
        System.out.println("Courses count: " + student.getAllCourses().length);
        System.out.println("Grades count: " + student.getAllGrades().length);
        System.out.println("Grade average " + student.getGradeAverage());
        testCoronaPassport(student, validPassVax);
        testCoronaPassport(student, validPassTested);
        testCoronaPassport(student, validPassInfected);
        testCoronaPassport(student, invalidPassTested1);
        testCoronaPassport(student, invalidPassTested2);
        testCoronaPassport(student, invalidInfected1);
        testCoronaPassport(student, invalidInfected2);

        //endregion

        writeBottomLine();
    }

    public static Lesson createLesson(Time start, Time end)
    {
        ArrayList<Resource> resources = new ArrayList<>();
        Date date = Date.today();
        Lesson lesson = null;
        try{
            lesson = new Lesson("Test", date, start, end, resources);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        return lesson;
    }

    public static CoronaPassport createCoronaPass(String reason)
    {
        CoronaPassport coronaPassport = null;
        try
        {
            coronaPassport = new CoronaPassport(reason, Date.today());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        return coronaPassport;
    }

    public static <T extends Lesson> void writeLessonList(ArrayList<T> lessons)
    {
        System.out.println("List size: " + lessons.size());
        for (Lesson l : lessons)
        {
            System.out.println(l);
        }
        System.out.println();
    }

    public static void testCoronaPassport(Student student, CoronaPassport passport)
    {
        student.removeCoronaPassport();
        student.addCoronaPassport(passport);
        System.out.println(student.getCoronaPassport());
        System.out.println("Valid passport: " + student.hasValidCoronaPassport());
    }

    public static void writeTitle(String text)
    {
        WriteHelper.writeTitle(text);
    }
    public static void writeBottomLine()
    {
        WriteHelper.writeBottomLine();
    }
}

class WriteHelper
{
    private final static String strangeCharacterHorizontal = "═";//"─";
    private final static String strangeCharacterVertical = "│";
    private final static String strangeCharacterCornerTop = "╒";//"┌";
    private final static String strangeCharacterCornerBottom = "╘";//"└";
    private final static PrintStream originalSystemOut = System.out;
    private final static int horizontalLineLength = 20;

    private static boolean writeFirstLine = false;
    private static String lastTitle = "";

    public static void writeTitle(String text)
    {
        String line = strangeCharacterHorizontal.repeat(horizontalLineLength);
        if(writeFirstLine)
        {
            writeBottomLine();
            originalSystemOut.println("\n");

        }

        lastTitle = text;
        writeFirstLine = true;
        originalSystemOut.println(strangeCharacterCornerTop + line + " " + text + " " + line + "\n" + strangeCharacterVertical);
    }
    public static void writeBottomLine()
    {
        int lineLength = horizontalLineLength * 2 + 2 + lastTitle.length();
        String bottomLine = strangeCharacterCornerBottom + strangeCharacterHorizontal.repeat(lineLength);
        originalSystemOut.println(bottomLine);
    }

    public static void setCorrectPrintStream()
    {
        PrintStream originalSystemOut = System.out;
        var myPrintThing = new PrintStream(originalSystemOut){

            @Override public void println()
            {
                println("");
            }
            @Override public void println(String x)
            {
                originalSystemOut.println(strangeCharacterVertical + "\t" + x);
            }
            @Override public void println(Object x)
            {
                if(x == null)
                    println("null");
                else
                    println(x.toString());
            }
        };
        System.setOut(myPrintThing);
    }
}


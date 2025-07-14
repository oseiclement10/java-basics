import java.util.ArrayList;
import java.util.Scanner;

public class Stage {

    private String name;
    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;

    private static ArrayList<String> takenNames = new ArrayList<>();

    public Stage(String stageName) {
        if (Stage.isNameTaken(stageName)) {
            throw new IllegalArgumentException("Stage name already taken");
        }
        this.name = stageName;
        this.studentList = new ArrayList<>();
        this.courseList = new ArrayList<>();
        takenNames.add(stageName);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void enRollStudent(Student newStudent) {
        if (this.inStage(newStudent)) {
            throw new IllegalArgumentException("Student" + newStudent.getName() + " already exists in stage ");
        }
        this.studentList.add(newStudent);
    }

    public void removeStudent(Student student) {
        if (!this.inStage(student)) {
            throw new IllegalArgumentException("Student " + student.getName() + " does not exist in stage");
        }
        this.studentList.remove(student);
    }

    public Boolean inStage(Student search) {
        for (Student student : this.studentList) {
            if (student.equals(search)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOnRoll() {
        return this.studentList.size();
    }

    public int getCoursesCount() {
        return this.courseList.size();
    }

    public static String readStageInfo(Scanner scanner) {

        Boolean isValid = false;

        String stageName = "";

        while (!isValid) {
            System.out.println("Enter stage name");
            stageName = scanner.nextLine();
            if (stageName.trim().length() > 1) {
                isValid = true;
            } else {
                System.out.println("Stage name cannot be empty or a single character");
            }
        }

        return stageName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Stage))
            return false;
        Stage otherStage = (Stage) other;
        return otherStage.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public static boolean isNameTaken(String stageName) {
        for (String name : Stage.takenNames) {
            if (name.equals(stageName))
                return true;
        }
        return false;
    }

}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

// TODO::  ADDING COURSE, ASSIGNING COURSE TO CLASS, SETUP MENU LAYERING

public class Main {
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Stage> stageList = new ArrayList<>();
    public static ArrayList<Course> courseList = new ArrayList<>();

    public static final void printLineBreak() {
        System.out.println("---------------------------------- \n" + "---------------------------------- \n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to School Ease School System ");

        Boolean read = true;

        while (read) {
            printLineBreak();

            System.out.println("What would you like to do, enter a number based on what you would like to do");
            System.out.println("1. Register Student");
            System.out.println("2. Add New stage");
            System.out.println("3. Enroll Student ");
            System.out.println("4. Assign course to class");
            System.out.println("5. List Courses");
            System.out.println("9. List students");
            System.out.println("10. Print stage list");

            System.out.println("0. Quit");

            String userInput = scanner.nextLine();

            try {
                int input = Integer.parseInt(userInput);

                switch (input) {
                    case 0:
                        read = false;
                        System.out.println("Exiting app ...");
                        break;

                    case 1:
                        // registration
                        registerStudent(scanner);
                        break;

                    case 2:
                        // Add class
                        addNewStage(scanner);
                        break;
                    case 3:
                        enrollStudent(scanner);
                        break;

                    case 5:
                        listItems(courseList, "courses");
                        break;

                    case 9:
                        // list students
                        listItems(studentList, "Students");
                        break;

                    case 10:
                        // list classes
                        listItems(stageList, "Stages");
                        break;

                    default:
                        System.out.println("Not a valid input try again");
                        break;
                }

            } catch (NumberFormatException invalidArg) {
                System.out.println("Please enter a number from the menu only");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        scanner.close();

    }

    public static void registerStudent(Scanner scanner) {
        printLineBreak();

        SimpleEntry<String, LocalDate> studentInfo = Student.readStudentInfo(scanner);
        Student student = new Student(studentInfo.getKey(), studentInfo.getValue());

        studentList.add(student);
        System.out.println("Registered " + student + " Succesfully ! .");

    }

    public static void enrollStudent(Scanner scanner) {
        printLineBreak();

        listItems(studentList, "Students");
        System.out.println();
        System.out.println("STUDENT ENROLLMENT");
        Student student = Student.getStudentByIndexInput(scanner, studentList);

        listItems(stageList, "stages");
        System.out.println();
        Stage stage = Stage.getStageByInput(scanner, stageList);
        stage.enRollStudent(student);

        printLineBreak();
        System.out.println("STUDENT " + student + "ENROLLED INTO" + stage.getName() + " SUCCESSFULLY");
    }

    public static void addNewStage(Scanner scanner) {
        printLineBreak();
        try {
            String stageInfo = Stage.readStageInfo(scanner);
            Stage stage = new Stage(stageInfo);

            stageList.add(stage);
            System.out.println("Stage added succesfully !");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void addNewCourse(Scanner scanner) {
        printLineBreak();
        try {
            String stageInfo = Stage.readStageInfo(scanner);
            Stage stage = new Stage(stageInfo);

            stageList.add(stage);
            System.out.println("Stage added succesfully !");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static <T> void listItems(ArrayList<T> list, String name) {
        printLineBreak();
        if (list.isEmpty()) {
            System.out.println("No " + name + " have been registered yet");
        } else {
            System.out.println("Student List : ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i));
            }
        }
    }

}
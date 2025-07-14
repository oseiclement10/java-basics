import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

// TODO:: ENROLL STUDENT INTO CLASS , ASSIGN COURSE TO CLASS

public class Main {
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Stage> stageList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to School Ease School System ");

        Boolean read = true;

        while (read) {
            System.out.println("What would you like to do, enter a number based on what you would like to do");
            System.out.println("1. Register Student");
            System.out.println("2. Add New stage");
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

                    case 9:
                        // list students
                        listStudents();
                        break;

                    case 10:
                        // list classes
                        listStages();
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

    public static void addNewStage(Scanner scanner) {
        try {
            String stageInfo = Stage.readStageInfo(scanner);
            Stage stage = new Stage(stageInfo);
            stageList.add(stage);
            System.out.println("Stage added succesfully !");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void registerStudent(Scanner scanner) {
        SimpleEntry<String, LocalDate> studentInfo = Student.readStudentInfo(scanner);
        Student student = new Student(studentInfo.getKey(), studentInfo.getValue());
        studentList.add(student);
        System.out.println("Registered " + student + " Succesfully ! .");
    }

    public static void listStudents() {
        if (studentList.size() == 0) {
            System.out.println("No students have been registered yet");
        } else {
            System.out.println("Student List : ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(i + 1 + ". " + studentList.get(i));
            }
        }
    }

    public static void listStages() {
        if (stageList.size() == 0) {
            System.out.println("No stage has been added yet");
        } else {
            System.out.println("Stage List : ");
            for (int i = 0; i < stageList.size(); i++) {
                System.out.println(i + 1 + ". " + stageList.get(i));
            }
        }
    }

}
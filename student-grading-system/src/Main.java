import java.time.LocalDate;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to School Ease School System ");

        Boolean read = true;

        while (read) {
            System.out.println("What would you like to do, enter a number based on what you would like to do");
            System.out.println("1. Register Student");
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
                        SimpleEntry<String, LocalDate> studentInfo = Student.readStudentInfo();
                        Student student = new Student(studentInfo.getKey(), studentInfo.getValue());
                        System.out.println("Registered " + student.getName() + " Succesfully ! .");
                        break;

                    default:
                        System.out.println("Not a valid input try again");
                        break;
                }

            } catch (NumberFormatException invalidArg) {
                System.out.println("Please enter a number from the menu only");
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
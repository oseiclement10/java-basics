import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

public class Student {

    private String name;
    private int indexNumber;
    private LocalDate dob;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static int lastStudentIndexNumber = 0;

    public Student(String studentName, String dateOfBirth) {
        this.name = studentName;
        this.dob = Student.formatDob(dateOfBirth);
        Student.lastStudentIndexNumber += 1;
        this.indexNumber = Student.lastStudentIndexNumber;
    }

    public Student(String studentName, LocalDate dateOfBirth) {
        this.name = studentName;
        this.dob = dateOfBirth;
        Student.lastStudentIndexNumber += 1;
        this.indexNumber = Student.lastStudentIndexNumber;
    }

    public int getIndexNumber() {
        return this.indexNumber;
    }

    public String getDateOfBirth() {
        return this.dob.format(Student.FORMATTER);
    }

    @Override
    public String toString() {
        return this.name + "_" + this.indexNumber;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared)
            return true;
        if (!(compared instanceof Student))
            return false;
        Student comparedStudent = (Student) compared;
        return comparedStudent.getIndexNumber() == this.getIndexNumber();
    }

    @Override
    public int hashCode() {
        return this.getIndexNumber();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String studentName) {
        this.name = studentName;
    }

    private static LocalDate formatDob(String dob) {
        try {
            LocalDate dobParsed = LocalDate.parse(dob, FORMATTER);
            if (dobParsed.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth cannot be after todays date");
            }
            return dobParsed;
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException("Date of birth must be of format dd-MM-yyyy");
        }
    }

    public static SimpleEntry<String, LocalDate> readStudentInfo() {

        Scanner scanner = new Scanner(System.in);

        Boolean isNameValid = false;
        Boolean isDobValid = false;

        String studentName = "";
        LocalDate dob = LocalDate.now();

        while (!isNameValid) {
            System.out.println("Enter Student Name");
            studentName = scanner.nextLine();
            if (studentName.length() > 1) {
                isNameValid = true;
            } else {
                System.out.println("Student name cannot be empty or a single character");
            }
        }

        while (!isDobValid) {
            System.out.println("Enter Student Date of Birth (dd-MM-yyyy)");
            String dobInput = scanner.nextLine();
            try {
                dob = Student.formatDob(dobInput);
                isDobValid = true;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }

        return new SimpleEntry<>(studentName, dob);

    }

}
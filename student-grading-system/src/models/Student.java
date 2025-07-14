import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Student {
    private String _name;
    private int _indexNumber;
    private LocalDate _dob;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static int lastStudentIndexNumber;

    public Student(String studentName, String dateOfBirth) {
        this._name = studentName;
        this._dob = this.formatDob(dateOfBirth);
        Student.lastStudentIndexNumber += 1;
        this._indexNumber = Student.lastStudentIndexNumber;
    }

    public int getIndexNumber() {
        return this._indexNumber;
    }

    public String getDateOfBirth(){
        return this._dob.format(Student.FORMATTER);
    }

    @Override
    public String toString() {
        return this._name + "_" + this._indexNumber;
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
        return this._name;
    }

    public void setName(String studentName) {
        this._name = studentName;
    }

    private LocalDate formatDob(String dob) {
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

}
import java.util.ArrayList;

public class Stage {

    private String name;
    private ArrayList<Student> studentList;
    private ArrayList<Course> courseList;

    public Stage(String stageName) {
        this.name = stageName;
        this.studentList = new ArrayList<>();
        this.courseList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void enRollStudent(Student newStudent) {
        if (this.inClass(newStudent)) {
            throw new IllegalArgumentException("Student" + newStudent.getName() + " already exists in class ");
        }
        this.studentList.add(newStudent);
    }

    public void removeStudent(Student student){
        if (!this.inClass(student)){
            throw new IllegalArgumentException("Student " + student.getName()+ " does not exist in class");
        }
        this.studentList.remove(student);
    }

    public Boolean inClass(Student search) {
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
}
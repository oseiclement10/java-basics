package  models;

public class Stage {
    public String name;
    private ArrayList<Student> _students;

    public Stage(String stageName){
        this.name = stageName;
        this._students = new ArrayList<>();
    }

    public int getNumberOnRoll () {
        return this._students.size();
    }

    public Student findStudent(String studentIndexNumber){
        for(Student student in this._students){
            if(student.indexNumber.equals(studentIndexNumber)){
                return student;
            }
        }
    }

    public void removeStudent(String studentIndexNumber){

    }

}
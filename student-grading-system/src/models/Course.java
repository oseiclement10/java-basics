public class Course {
    private String name;
    private String code;
    private String classId;
    
    public Course(String className, String classCode, String classId){
        this.name = className;
        this.code = classCode;
        this.classId = classId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCode(){
        return this.code;
    }

    public void setClassId(String classId){
        this.classId = classId;
    }

    public String getClassId(){
        return this.classId;
    }
}

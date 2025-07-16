public class Course {
    private String name;
    private String code;
    private String stageName;
    
    public Course(String className, String classCode, String stageName){
        this.name = className;
        this.code = classCode;
        this.stageName = stageName;
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

    public void setstageName(String stageName){
        this.stageName = stageName;
    }

    public String getstageName(){
        return this.stageName;
    }
}

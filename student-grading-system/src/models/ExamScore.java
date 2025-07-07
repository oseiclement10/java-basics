package models;

public class ExamScore {
    private final String _courseCode;
    private double _courseScore;

    public ExamScore(String courseCode, double score){
            this._courseCode = courseCode;
            this._courseScore = score;
    }

    public String getCourseCode(){
        return this._courseCode;
    }

    public void setScore (double examScore){
            this._courseScore = examScore;
    }

    public double getScore(){
        return this._courseScore;
    }


}
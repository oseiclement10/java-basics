package  models;

import java.util.ArrayList;

public class Student {
    public int studentId;
    public String name;
    private ArrayList<ExamScore> _grades;

    public Student(int id, String studentName){
        this.name = studentName;
        this.studentId = id;
        this._grades = new ArrayList<>();
    }

    public double calculateAverage(){
        double total = this.getTotalScore();
        return total/this._grades.size();
    }

    public double getHighestGrade(){
        double highest = 0;
        for(ExamScore exScore : this._grades){
            if(exScore.getScore() > highest){
                highest = exScore.getScore();
            }
        }
        return highest;
    }

    public double getTotalScore(){
        double scores = 0;

        for(ExamScore exScore : this._grades){
            scores += exScore.getScore();
        }

        return scores;
    }

    public void displayInfo(){
        System.out.println(this.name + " had a total of " + this.getTotalScore() + ". He had an average of " + this.calculateAverage());
    }

    public ExamScore getExamScore(String courseCode){
        for(ExamScore exScore : this._grades){
            if(exScore.getCourseCode().equals(courseCode)){
                return exScore;
            }
        }

        return null;
    }

    public void enterScore(String courseCode, double score){
            ExamScore existingExamScore = this.getExamScore(courseCode);
            if(existingExamScore != null){
                existingExamScore.setScore(score);
            }else{
                this._grades.add(new ExamScore(courseCode,score));
            }
    }

}
package model;


import java.util.ArrayList;

public class Transcript {
/*
  INVARIANT: course list and grade list are the same size
  each course has a grade associated, and vice versa, at matching indices
*/

    String studentName;
    int studentID;
    ArrayList<String> courseList;
    ArrayList<Double> gradeList;
    int syncIndex;

    public Transcript(String studentName, int studentID){
        this.studentName = studentName;
        this.studentID = studentID;
        courseList = new ArrayList<>();
        gradeList = new ArrayList<>();
    }

    //REQUIRES: grade should be between 0.0 and 4.0, course should not be null
    //MODIFIES: this
    //EFFECTS: adds course and corresponding grade to transcript
    public void addGrade(String course, double grade){
        courseList.add(course);
        gradeList.add(grade);
    }

    //REQUIRES: a course the student has already taken
    //EFFECTS: returns course name and grade in format "CourseName: grade"
    public String getCourseAndGrade(String course){
        syncIndex = 0;
        for (String c : courseList){
            if(c == course){
                return c + ": " + gradeList.get(syncIndex);
            }
            else {syncIndex++;
            }
        }
        return null;
    }

    //EFFECTS: prints course names with grades earned
    public void printTranscript(){
        syncIndex = 0;
        for (String c : courseList){
            System.out.println(c + ": " + gradeList.get(syncIndex));
            syncIndex++;
        }


    }

    //EFFECTS: calculates average of all course grades
    public double getGPA(){
        double sum = 0.0;
        for(double g : gradeList){
            sum = sum + g;
        }
        return sum/gradeList.size();
    }


    // GETTERS
    public String getStudentName(){
        return studentName;
    }

    public int getStudentID(){
        return studentID;
    }


    // SETTERS //TODO add confirm messages
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
}

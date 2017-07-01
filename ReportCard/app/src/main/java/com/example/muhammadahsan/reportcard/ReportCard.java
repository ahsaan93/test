package com.example.muhammadahsan.reportcard;

public class ReportCard {
    private int [] reportID = {1,2};
    private String [] studentID = {"100","101"};
    private String [] studentName = {"Ahsan","Farhan"};
    private String [] studentClass = {"9th","10th"};
    private int [] passingYear = {2008,2009};
    private int [] studentMarks = {88,45};
    private int counter = 0;
    private String id, grade,division,studentDetail;
    private int tempReportID [];
    private String tempStudentID [];
    private String tempStudentName [];
    private String tempStudentClass [];
    private int tempPassingYear [];
    private int tempStudentMarks [];


    public ReportCard(String stuID, String stuName, String stuClass, int passYear, int stuMarks) {
        if (counter==reportID.length){

            tempReportID = new int[reportID.length*2];
            tempStudentID = new String [studentID.length*2];
            tempStudentName = new String[studentName.length*2];
            tempStudentClass = new String[studentClass.length*2];
            tempPassingYear = new int[passingYear.length*2];
            tempStudentMarks = new int[studentMarks.length*2];

            for (int i=0;i<reportID.length;i++){

                tempReportID[i] = reportID[i];
                tempStudentID[i] = studentID[i];
                tempStudentName[i] = studentName[i];
                tempStudentClass[i] = studentClass[i];
                tempPassingYear[i] = passingYear[i];
                tempStudentMarks[i] = studentMarks[i];
            }

            reportID = tempReportID;
            studentID = tempStudentID;
            studentName = tempStudentName;
            studentClass = tempStudentClass;
            passingYear = tempPassingYear;
            studentMarks = tempStudentMarks;
        }

        this.reportID[counter] = counter+1;
        this.studentID[counter] = stuID;
        this.studentName[counter] = stuName;
        this.studentClass[counter] = stuClass;
        this.passingYear[counter] = passYear;
        this.studentMarks[counter] = stuMarks;
        counter++;
    }

    public String getStudentID(String stuID) {
        studentDetail = null;
        for (int i=0;i<reportID.length;i++){
            id = studentID[i];
            if (stuID.equals(id)){
                studentDetail =
                                "Student ID # "           + studentID[i] +
                                "\nStudent Name: "          + studentName[i] +
                                "\nStudent Class: "         + studentClass[i] +
                                "\nStudent Passing Year: "  + passingYear[i] +
                                "\nStudent Grade: "         + grade(studentMarks[i]) +
                                "\nStudent Division: "      + divisioin(studentMarks[i]);
            }

        }

        if (studentDetail==null){
            return "Sorry! Student not found!";
        }else{
            return studentDetail;
        }
    }

    public void setStudentID(String stuID, String stuName, String stuClass, int passYear, int stuMarks) {
        if (counter==reportID.length){

            tempReportID = new int[reportID.length*2];
            tempStudentID = new String [studentID.length*2];
            tempStudentName = new String[studentName.length*2];
            tempStudentClass = new String[studentClass.length*2];
            tempPassingYear = new int[passingYear.length*2];
            tempStudentMarks = new int[studentMarks.length*2];

            for (int i=0;i<reportID.length;i++){

                tempReportID[i] = reportID[i];
                tempStudentID[i] = studentID[i];
                tempStudentName[i] = studentName[i];
                tempStudentClass[i] = studentClass[i];
                tempPassingYear[i] = passingYear[i];
                tempStudentMarks[i] = studentMarks[i];
            }

            reportID = tempReportID;
            studentID = tempStudentID;
            studentName = tempStudentName;
            studentClass = tempStudentClass;
            passingYear = tempPassingYear;
            studentMarks = tempStudentMarks;
        }

        this.reportID[counter] = counter+1;
        this.studentID[counter] = stuID;
        this.studentName[counter] = stuName;
        this.studentClass[counter] = stuClass;
        this.passingYear[counter] = passYear;
        this.studentMarks[counter] = stuMarks;
        counter++;
    }
    private String divisioin(int marks){
        if (marks > 0){
            if(marks >= 65){
                return "1st Division";
            }else if(marks >= 45){
                return "2nd Division";
            }else if(marks >= 40){
                return "3rd Division";
            }else{
                return "Fail";
            }
        }else {
            return "Marks not found";
        }


    }
    private String grade(int marks){
        if (marks > 0){
            if (marks >= 80){
                return "A";
            }else if(marks >= 65){
                return "B";
            }else if(marks >= 50){
                return "C";
            }else if(marks >= 40){
                return "D";
            }else{
                return "F";
            }
        }else {
            return "Marks not found";
        }
    }
}
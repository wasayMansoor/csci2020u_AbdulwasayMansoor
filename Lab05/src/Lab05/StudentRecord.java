package Lab05;

public class StudentRecord {
    private final String StudentID;
    private final float Assignments;
    private final float Midterm;
    private final float FinalExam;
    private final float FinalMark;
    private final char LetterGrade;

    //letterGradeBoundary
    public StudentRecord(String s, float a, float m, float f){
        this.StudentID = s;
        this.Assignments = a;
        this.Midterm = m;
        this.FinalExam = f;
        this.FinalMark = (float) ((0.2*a) + (0.3*m) + (0.5*f));

        if (this.FinalMark >= 80){
            this.LetterGrade = 'A';
        }
        else if (this.FinalMark >= 70){
            this.LetterGrade = 'B';
        }
        else if (this.FinalMark >= 60){
            this.LetterGrade = 'C';
        }
        else if (this.FinalMark >= 50){
            this.LetterGrade = 'D';
        }
        else{
            this.LetterGrade = 'F';
        }
    }

    public String getStudentID(){
        return this.StudentID;
    }
    public float getAssignments(){
        return this.Assignments;
    }
    public float getMidterm(){
        return this.Midterm;
    }
    public float getFinalExam(){
        return this.FinalExam;
    }
    public float getFinalMark(){
        return this.FinalMark;
    }
    public char getLetterGrade(){
        return this.LetterGrade;
    }
}

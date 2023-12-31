package UI;

import model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Joshua Chew", 95081204);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t2.addGrade("ENGL-110", 0.0);
        t2.addGrade("CHIN-131", 4.0);
        t2.addGrade("MOMM-420", 2.0);

        t3.addGrade("CPSC-110", 4.0);
        t3.addGrade("BIOL-111", 1.0);
        t3.addGrade("CPSC-121", 4.0);
        t3.addGrade("PHIL-220", 4.0);


        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

        System.out.println(t2.getStudentName() + ": " + t2.getStudentID());
        t2.setStudentName("Ass Licker");
        t2.setStudentID(42069);
        System.out.println(t2.getStudentName() + ": " + t2.getStudentID());

        t3.getCourseAndGrade("CPSC-110");


    }
}

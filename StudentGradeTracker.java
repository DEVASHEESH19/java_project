import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Grade Tracker");
        System.out.println("Enter number of subjects:");
        int nS = sc.nextInt();
        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < nS; i++) {
            System.out.println("Enter marks obtained in subject " + (i + 1) + ": ");
            int marks = sc.nextInt();
            total += marks;
            if (marks > highest) {
                highest = marks;
            }
            if (marks < lowest) {
                lowest = marks;
            }
        }

        double averP = (double) total / nS;
        char grade;
        if (averP >= 90) {
            grade = 'O';
        } else if (averP >= 80) {
            grade = 'A';
        } else if (averP >= 70) {
            grade = 'B';
        } else if (averP >= 60) {
            grade = 'C';
        } else if (averP >= 50) {
            grade = 'D';
        } else if (averP >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("Total marks scored is " + total);
        System.out.println("Average percentage gained is " + averP + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Highest marks: " + highest);
        System.out.println("Lowest marks: " + lowest);
    }
}




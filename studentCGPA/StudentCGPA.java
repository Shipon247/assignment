import java.util.Scanner;

public class StudentCGPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();

        double totalCredit = 0;
        double earnedCredit = 0;
        double weightedGP = 0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("\nCourse " + i + ":");

            System.out.print("Credit (Max 3): ");
            double credit = sc.nextDouble();

            System.out.print("CT (out of 30): ");
            double ct = sc.nextDouble();

            System.out.print("AT (out of 10): ");
            double at = sc.nextDouble();

            System.out.print("FE (out of 60): ");
            double fe = sc.nextDouble();

            double totalMarks = ct + at + fe;
            double gp = 0.0;

            if (totalMarks >= 80) gp = 4.0;
            else if (totalMarks >= 75) gp = 3.75;
            else if (totalMarks >= 70) gp = 3.5;
            else if (totalMarks >= 65) gp = 3.25;
            else if (totalMarks >= 60) gp = 3.0;
            else if (totalMarks >= 55) gp = 2.75;
            else if (totalMarks >= 50) gp = 2.5;
            else if (totalMarks >= 45) gp = 2.25;
            else if (totalMarks >= 40) gp = 2.0;
            else gp = 0.0;

            totalCredit += credit;
            if (gp > 0) earnedCredit += credit;
            weightedGP += (gp * credit);
        }

        double cgpa = weightedGP / totalCredit;

        String grade;
        if (cgpa >= 4.00) grade = "A+";
        else if (cgpa >= 3.75) grade = "A";
        else if (cgpa >= 3.50) grade = "A-";
        else if (cgpa >= 3.25) grade = "B+";
        else if (cgpa >= 3.00) grade = "B";
        else if (cgpa >= 2.75) grade = "B-";
        else if (cgpa >= 2.50) grade = "C+";
        else if (cgpa >= 2.25) grade = "C";
        else if (cgpa >= 2.00) grade = "D";
        else grade = "F";

        System.out.println("\n----------------------------------");
        System.out.println("Student ID: " + studentID);
        System.out.println("Credit Taken: " + totalCredit);
        System.out.println("Credit Earned: " + earnedCredit);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------------");

        sc.close();
    }
}
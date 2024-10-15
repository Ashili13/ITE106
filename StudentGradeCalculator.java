import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = scanner.nextInt();

        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averages = new double[numStudents];
        char[] letterGrades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name for student " + (i + 1) + ": ");
            studentNames[i] = scanner.next();

            double total = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
                total += grades[i][j];
            }
            averages[i] = total / numAssignments;
            letterGrades[i] = getLetterGrade(averages[i]);
        }

        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Name: " + studentNames[i] + " Scores: ");
            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println("Average: " + averages[i] + " Grade: " + letterGrades[i]);
        }

        double highest = averages[0];
        double lowest = averages[0];
        String highestStudent = studentNames[0];
        String lowestStudent = studentNames[0];

        for (int i = 1; i < numStudents; i++) {
            if (averages[i] > highest) {
                highest = averages[i];
                highestStudent = studentNames[i];
            }
            if (averages[i] < lowest) {
                lowest = averages[i];
                lowestStudent = studentNames[i];
            }
        }

        System.out.println("\nHighest average: " + highest + " (" + highestStudent + ")");
        System.out.println("Lowest average: " + lowest + " (" + lowestStudent + ")");

  
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (averages[j] < averages[j + 1]) {
                    
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    
                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                   
                    char tempGrade = letterGrades[j];
                    letterGrades[j] = letterGrades[j + 1];
                    letterGrades[j + 1] = tempGrade;

                    
                    double[] tempScores = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempScores;
                }
            }
        }
        
        System.out.println("\nSorted list of students by average score:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Name: " + studentNames[i] + " Average: " + averages[i] + " Grade: " + letterGrades[i] + " Scores: ");
            for (int j = 0; j < numAssignments; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static char getLetterGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 85) {
            return 'B';
        } else if (average >= 80) {
			return 'C';
		} else if (average >= 75) {
			return 'D';
		}else {
			return 'F';
		}
	}
}
import.java.until.scanner;

public class student_calculator {

	public static void main(string []args) {
		Scanner scanner = new Scanner(System.in);
	
		System.out.print("Enter a number of student:");
		int numStudent = Scanner.nextInt();
		
		String[] studentName = new string[numStudent];
		double[] studentAverages = new double[numStudent];
		char[] studentGrades = char[numStudent];
		
		for (int i = 0 ; i < numStudents; i++){
			System.out.println("Enter details for students" + (i + 1)+ ":");
			System.out.println("Name: ")
			studentNames[i] = scanner.next();
			
			System.out.print("number of assignment: ");
			int numAssignments = scanner.nextInt();
			double[] score = new double[numAssignments];
			
			double total = 0;
			for (int j = 0 ; j < numAssignments; j++ ) {
				System.out.print("score for assignment " + (j + 1) + ": ");
				scores[j] = scanner.nextdouble();
				total += scores[j];
			}
			
			double average = total / numAssignments;
			studentAverages[j] = average;
			studentGrades[i] = getletterGrade(average);
		}
		
		System.out.println("\nStudent Grades: ");
		for (int i = 0; i < numStudents; i++);
			System.out.println("Name: " + studentNames[i] + ", Average: " + studentAverages[i] + studentAverages[i] ", Grade: " + studentGrades[i]);
		}
			
		scanner.close();
	}
	
	private static char getletterGrade(double average) {
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
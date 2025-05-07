import java.util.Scanner;

public class GradeStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numGrades = 10;
        double total = 0;
        double maxGrade = Double.MIN_VALUE;
        double minGrade = Double.MAX_VALUE;

        System.out.println("Enter " + numGrades + " grades (0 - 100):");

        for (int i = 0; i < numGrades; ) {
            System.out.print("Grade " + (i + 1) + ": ");
            if (scanner.hasNextDouble()) {
                double grade = scanner.nextDouble();

                // Here we ensure that only scores from 0 to 100 are allowed to prevent logic errors
                if (grade >= 0 && grade <= 100) {
                    total += grade;

                    if (grade > maxGrade) {
                        maxGrade = grade;
                    }
                    if (grade < minGrade) {
                        minGrade = grade;
                    }

                    i++; // only increment if it's valid
                } else {
                    System.out.println("Nice try, but only numbers between 0 and 100 are allowed.");
                }
            } else {
                System.out.println("That's not a number. Use the keys above the letters please.");
                scanner.next(); // clear bad input
            }
        }

        double average = total / numGrades;

        System.out.println("\nGrade Statistics:");
        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Maximum: %.2f\n", maxGrade);
        System.out.printf("Minimum: %.2f\n", minGrade);

        scanner.close();
    }
}

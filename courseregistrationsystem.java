import java.util.Scanner;

public class courseregistrationsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new student
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        student student = new student(studentName);

        // Menu
        while (true) {
            System.out.println("\n1. Enroll in a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter course name to enroll: ");
                    String courseToEnroll = scanner.nextLine();
                    student.enrollCourse(courseToEnroll);
                    System.out.println("Enrolled in course: " + courseToEnroll);
                    break;
                case 2:
                    System.out.print("Enter course name to drop: ");
                    String courseToDrop = scanner.nextLine();
                    student.dropCourse(courseToDrop);
                    System.out.println("Dropped course: " + courseToDrop);
                    break;
                case 3:
                    System.out.println(student);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

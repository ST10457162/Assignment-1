
package student;

/**
 *
 * @author Mahum
 */
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private int age;
    private String course;

    public Student(String studentID, String firstName, String lastName, int age, String course) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nFirst Name: " + firstName + "\nLast Name: " + lastName +
                "\nAge: " + age + "\nCourse: " + course;
    }
}

public class StudentManagementSystem {
    
    //w3schools (2019). JavaScript Array Methods. [online] W3schools.com. Available at: https://www.w3schools.com/js/js_array_methods.asp.
    static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Capture New Student");
        System.out.println("2. Search Student");
        System.out.println("3. Delete Student");
        System.out.println("4. View Student Report");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                captureStudent();
                break;
            case 2:
                searchStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                viewStudentReport();
                break;
            case 5:
                System.out.println("Exiting the application...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void captureStudent() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        int age = 0;
        while (true) {
            System.out.print("Enter Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (age >= 16) break;
                else System.out.println("Age must be 16 or older.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        students.add(new Student(studentID, firstName, lastName, age, course));
        System.out.println("Student details successfully saved.");
    }

    public static void searchStudent() {
        
        //GeeksforGeeks. (2019). Java main() Method - public static void main(String[] args). [online] Available at: https://www.geeksforgeeks.org/java-main-method-public-static-void-main-string-args/.
        System.out.print("Enter Student ID to search: ");
        String studentID = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                System.out.println("Student Found:\n" + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String studentID = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                students.remove(student);
                System.out.println("Student successfully deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void viewStudentReport() {
        
        //W3Schools (n.d.). Java If ... Else. [online] www.w3schools.com. Available at: https://www.w3schools.com/java/java_conditions.asp.
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student Report:");
            for (Student student : students) {
                System.out.println(student + "\n");
            }
        }
    }
}

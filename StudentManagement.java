// Importing the required classes from the java.util package.
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
  // ArrayList to store the records of the students.
  private static ArrayList<Student> records = new ArrayList<>();

  // Main method that creates an object of the StudentManagement class and calls the run method.
  public static void main(String[] args) {
    StudentManagement studentManagement = new StudentManagement();
    studentManagement.run();
  }

  public void run() {
    // Scanner object created to take user input.
    Scanner scanner = new Scanner(System.in);
    // While loop that runs until the user chooses to exit.
    while (true) {
      System.out.println("1. Add a Student\n2. Update Student Information\n3. Student Details\n4. Exit");
      // Try-catch block to handle invalid input instead of breaking the program.
      try {
        // User input is taken and stored in the option variable.
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline because nextInt() does not consume a newline.
        // Switch statement that calls the appropriate method based on the user's input.
        switch (option) {
          case 1:
            addStudent(scanner);
            break;
          case 2:
            updateStudent(scanner);
            break;
          case 3:
            studentDetails(scanner);
            break;
          case 4:
            System.out.println("Exiting...");
            return;
          default:
            System.out.println("Invalid option. Please try again.");
        }
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter an integer.");
        scanner.nextLine();
      }
    }
  }
  // Method to add a student to the records ArrayList.
  public void addStudent(Scanner scanner) {
    // Try-catch block to handle invalid input instead of breaking the program.
    try {
      System.out.println("Enter name: ");
      String name = scanner.nextLine();
      System.out.println("Enter id: ");
      String id = scanner.nextLine();
      System.out.println("Enter age(should be and integer): ");
      int age = scanner.nextInt();
      System.out.println("Enter grade(should be an integer): ");
      double grade = scanner.nextDouble();
      // Check if the student already exists in the records ArrayList.
      Student student = findStudent(id);
      if (student == null) {
        // If the student does not exist, add the student to the records ArrayList.
        records.add(new Student(name, id, age, grade));
      } else {
        System.out.println("The Student you are trying to create already exists.");

      }
    } catch (Exception e) {
      System.out.println("Invalid input. Please try again.");
      scanner.nextLine();
    }
  }
  // Method to update the information of a student in the records ArrayList.
  public void updateStudent(Scanner scanner) {
    try {
      System.out.println("Enter the id of the student you want to update:");
      String id = scanner.nextLine();
      // Find the student in the records ArrayList.
      Student student = findStudent(id);
      // If the student exists, update the information.
      if (student != null) {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter id: ");
        String newID = scanner.nextLine();
        System.out.println("Enter age(should be and integer): ");
        int age = scanner.nextInt();
        System.out.println("Enter grade(should be an integer): ");
        double grade = scanner.nextDouble();
        // Update the student's information.
        student.setStudentInfo(name, newID, age, grade);
      } else {
        System.out.println("The Student you are trying to update does not exist.");
      }
    } catch (Exception e) {
      System.out.println("Invalid input. Please try again.");
      scanner.nextLine();
    }
  }
  // Method to display the details of a student.
  public void studentDetails(Scanner scanner) {
    try {
      System.out.println("Enter the id of the student you want to see the details of:");
      String id = scanner.nextLine();
      // Find the student in the records ArrayList.
      Student student = findStudent(id);
      // If the student exists, display the student's information.
      if (student != null) {
        System.out.println("Name: " + student.name);
        System.out.println("ID: " + student.id);
        System.out.println("Age: " + student.age);
        System.out.println("Grade: " + student.grade);
      } else {
        System.out.println("The Student you are trying to see the details of does not exist.");
      }
    } catch (Exception e) {
      System.out.println("Invalid input. Please try again.");
      scanner.nextLine();
    }
  }
  // Helper method to find a student in the records ArrayList.
  private Student findStudent(String id) {
    for (Student student : records) {
      if (student.id.equals(id)) {
        return student;
      }
    }
    return null;
  }
  // Student class with name, id, age, and grade as attributes.
  public class Student {
    private String name;
    private String id;
    private int age;
    private double grade;

    public Student(String name, String id, int age, double grade) {
      this.name = name;
      this.id = id;
      this.age = age;
      this.grade = grade;
    }
    // Method to set the information of a student.
    public void setStudentInfo(String name, String id, int age, double grade) {
      this.name = name;
      this.id = id;
      this.age = age;
      this.grade = grade;
    }
  }
}
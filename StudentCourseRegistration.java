import java.util.*;

class Course {
    String courseId;
    String courseName;

    Course(String id, String name) {
        this.courseId = id;
        this.courseName = name;
    }

    public String toString() {
        return courseId + " - " + courseName;
    }
}

class Student {
    String studentId;
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String id, String name) {
        this.studentId = id;
        this.name = name;
    }

    void registerCourse(Course course) {
        courses.add(course);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(studentId).append(" - ").append(name).append("\nCourses: ");
        if (courses.isEmpty()) {
            sb.append("None");
        } else {
            for (Course c : courses) {
                sb.append("\n  ").append(c);
            }
        }
        return sb.toString();
    }
}

public class StudentCourseRegistration {
    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        loadCourses();

        while (true) {
            System.out.println("\n==== Student Course Registration System ====");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course for Student");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> registerCourseForStudent();
                case 3 -> viewStudents();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void loadCourses() {
        courses.add(new Course("CSE101", "Data Structures"));
        courses.add(new Course("CSE102", "OOP in Java"));
        courses.add(new Course("CSE103", "Database Systems"));
        courses.add(new Course("CSE104", "Operating Systems"));
    }

    static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added!");
    }

    static void registerCourseForStudent() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Available Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }

        System.out.print("Enter course number to register: ");
        int courseIndex = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        if (courseIndex >= 0 && courseIndex < courses.size()) {
            Course selectedCourse = courses.get(courseIndex);
            student.registerCourse(selectedCourse);
            System.out.println("Course registered!");
        } else {
            System.out.println("Invalid course selection.");
        }
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : students) {
            System.out.println("\n" + s);
        }
    }

    static Student findStudentById(String id) {
        for (Student s : students) {
            if (s.studentId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}

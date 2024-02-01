package Internship;

import java.util.ArrayList;
import java.util.List;

class Course
{
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule)
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        } else {
            return false;
        }
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }
}

public class Task_5
{
    private List<Course> courses;
    private List<Student> students;

    public Task_5() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourseListing() {
        System.out.println("Course Listing:");
        for (Course course : courses) {
            System.out.println("Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Enrolled Students: " + course.getEnrolledStudents().size());
            System.out.println("Available Slots: " + (course.getCapacity() - course.getEnrolledStudents().size()));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Task_5 system = new Task_5();

        Course c1 = new Course("CSCI101", "Introduction to Computer Science", "Basic concepts of programming", 30, "MWF 10:00 AM");
        Course c2 = new Course("MATH201", "Calculus I", "Advanced calculus topics", 25, "TTh 2:00 PM");
        system.addCourse(c1);
        system.addCourse(c2);

        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");
        system.addStudent(s1);
        system.addStudent(s2);


        system.displayCourseListing();


        s1.registerCourse(c1);
        s2.registerCourse(c2);


        system.displayCourseListing();


        s2.dropCourse(c2);


        system.displayCourseListing();
    }
}

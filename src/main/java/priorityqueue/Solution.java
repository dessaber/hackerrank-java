package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> ratedStudents = new PriorityQueue<>(5, Student.getStudentComparator());
        for (String event: events) {
            String[] parsedEvent = event.split(" ");
            switch (parsedEvent[0]) {
                case "SERVED": ratedStudents.poll();
                    break;
                case "ENTER":  ratedStudents.add(
                        new Student(Integer.parseInt(parsedEvent[3]), parsedEvent[1], Double.parseDouble(parsedEvent[2]))
                );
                    break;
            }
        }
        List<Student> outputStudents = new ArrayList<>();
        while (!ratedStudents.isEmpty()) {
            outputStudents.add(ratedStudents.poll());
        }
        return outputStudents;
    }
}

class Student {
    private int id;
    private String name;
    private double cpga;
    private static Comparator<Student> studentComparator = Comparator.comparing(Student::getCpga, Comparator.reverseOrder())
            .thenComparing(Student::getName)
            .thenComparing(Student::getId);


    public Student(int id, String name, double cpga) {
        this.id = id;
        this.name = name;
        this.cpga = cpga;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpga=" + cpga +
                '}';
    }

    public double getCpga() {
        return cpga;
    }

    public static Comparator<Student> getStudentComparator() {
        return studentComparator;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
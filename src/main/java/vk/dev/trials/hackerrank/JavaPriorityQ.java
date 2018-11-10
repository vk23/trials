package vk.dev.trials.hackerrank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * JavaPriorityQ.
 *
 * @author vladimir_kuragin
 */
public class JavaPriorityQ {

    static class Student {
        int id;
        String name;
        double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cgpa=" + cgpa +
                    '}';
        }
    }

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.getCgpa() == s2.getCgpa()) {
                if (s1.getName().equals(s2.getName())) {
                    if (s1.getId() == s2.getId()) {
                        return 0;
                    } else {
                        return s1.getId() > s2.getId() ? 1 : -1;
                    }
                } else {
                    return (s1.getName().compareTo(s2.getName()));
                }
            }
            return s1.getCgpa() > s2.getCgpa() ? -1 : 1;
        }
    }

    static class Priorities {
        private PriorityQueue<Student> q =  new PriorityQueue<>(new StudentComparator());

        List<Student> getStudents(List<String> events) {
            for (String e: events) {
                processEvent(e);
            }
            return q.stream().sorted(new StudentComparator()).collect(Collectors.toList());
        }

        private void processEvent(String event) {
            if ("SERVED".equals(event)) {
                Student st = q.poll();
                System.out.println("SERVED: " + st);
            } else {
                event = event.replace("ENTER ", "");
                String[] split = event.split(" ");
                if (split.length < 3) {
                    return;
                }
                Student newSt = new Student(Integer.parseInt(split[2]), split[0], Double.parseDouble(split[1]));
                boolean offer = q.offer(newSt);
                System.out.println("ENTERED: " + newSt + " ---> " + offer);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(sampleInput());
        Priorities priorities = new Priorities();

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
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }

    private static String sampleInput() {
        return "12\n" +
                "ENTER John 3.75 50\n" +
                "ENTER Mark 3.8 24\n" +
                "ENTER Shafaet 3.7 35\n" +
                "SERVED\n" +
                "SERVED\n" +
                "ENTER Samiha 3.85 36\n" +
                "SERVED\n" +
                "ENTER Ashley 3.9 42\n" +
                "ENTER Maria 3.6 46\n" +
                "ENTER Anik 3.95 49\n" +
                "ENTER Dan 3.95 50\n" +
                "\n";
    }
}

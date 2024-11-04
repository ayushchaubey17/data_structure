package heaps;

import java.util.PriorityQueue;

public class ForObject {
    static  class Student implements  Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank- s2.rank;
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Student("ayush", 12));
        priorityQueue.offer(new Student("ayush", 1));
        priorityQueue.offer(new Student("ayush", 4));
        priorityQueue.offer(new Student("ayush", 6));
        priorityQueue.offer(new Student("ayush", 3));

        while (!priorityQueue.isEmpty()) System.out.println(priorityQueue.poll().rank );

    }




}

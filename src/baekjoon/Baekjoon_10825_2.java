package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_10825_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student(br.readLine());
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name);
        }
    }

    static class Student implements Comparable<Student> {

        String name;
        int korean;
        int english;
        int math;

        public Student(String input) {
            String[] split = input.split(" ");
            this.name = split[0];
            this.korean = Integer.parseInt(split[1]);
            this.english = Integer.parseInt(split[2]);
            this.math = Integer.parseInt(split[3]);
        }

        @Override
        public int compareTo(Student o) {
            if (korean != o.korean) return o.korean - korean;
            if (english != o.english) return english - o.english;
            if (math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }
}
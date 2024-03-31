package sort;

import java.io.*;
import java.util.*;

public class BOJ10825 {
    static int N;
    static Student[] students;
    static StringBuilder sb = new StringBuilder();

    static class Student implements Comparable<Student>{
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Student other) {
            if (korean != other.korean) return other.korean - korean;
            if (english != other.english) return english - other.english;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    static void process() {
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            sb.append(students[i].name).append("\n");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new Student[N];
        StringTokenizer st;
        for (int i = 0; i < students.length; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student();
            students[i].name = st.nextToken();
            students[i].korean = Integer.parseInt(st.nextToken());
            students[i].english = Integer.parseInt(st.nextToken());
            students[i].math = Integer.parseInt(st.nextToken());
        }

        process();
        System.out.println(sb.toString());
    }
}

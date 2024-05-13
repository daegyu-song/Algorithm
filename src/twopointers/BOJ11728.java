package twopointers;

import java.io.*;
import java.util.*;

public class BOJ11728 {
    static int N, M;
    static int[] answer;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new int[N + M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = N; i < answer.length; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        Arrays.sort(answer);
        for (int i : answer) sb.append(i).append(" ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}

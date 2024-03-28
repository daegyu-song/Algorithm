package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15656 {
    static int N, M;
    static int[] selected;
    static int[] numbers;

    static StringBuilder sb = new StringBuilder();

    static void solution(int k) {
        if (k == M) {
            for (int i : selected) sb.append(i).append(" ");
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                selected[k] = numbers[i];
                solution(k + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selected = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        solution(0);
        System.out.println(sb.toString());
    }
}

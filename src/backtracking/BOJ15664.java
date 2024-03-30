package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15664 {
    static int N, M;
    static int[] numbers;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void solution(int depth, int idx) {
        if (depth == M) {
            for (int i : selected) sb.append(i).append(" ");
            sb.append("\n");
        } else {
            int before = 0;
            for (int i = idx; i < N; i++) {
                if (before != numbers[i]) {
                    before = numbers[i];
                    selected[depth] = numbers[i];
                    solution(depth + 1, i + 1);
                }
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

        solution(0, 0);

        System.out.println(sb.toString());
    }
}

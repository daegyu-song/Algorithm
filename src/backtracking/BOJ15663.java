package backtracking;

import java.io.*;
import java.util.*;

public class BOJ15663 {
    static int N, M;
    static int[] numbers;
    static boolean[] visits;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void solution(int depth) {
        if (depth == M) {
            for (int i : selected) sb.append(i).append(" ");
            sb.append("\n");
        } else {
            int before = 0;
            for (int i = 0; i < N; i++) {
                if (!visits[i] && before != numbers[i]) {
                    visits[i] = true;
                    before = numbers[i];
                    selected[depth] = numbers[i];
                    solution(depth + 1);
                    visits[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        selected = new int[M];
        visits = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        solution(0);

        System.out.println(sb.toString());
    }

}

package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15654 {
    static int N, M;
    static int[] selected;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visits;

    static void solution(int k) {
        if (k == M) {
            for (int i : selected) sb.append(i).append(" ");
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (!visits[i]) {
                    visits[i] = true;
                    selected[k] = numbers[i];
                    solution(k + 1);
                    visits[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];
        numbers = new int[N];
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

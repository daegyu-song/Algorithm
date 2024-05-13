package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15652 {
    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    static void solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            int start = arr[k - 1];
            if (start == 0) start = 1;
            for (int i = start; i <= N; i++) {
                arr[k] = i;
                solution(k + 1);
                arr[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];

        solution(1);
        System.out.println(sb.toString());
    }
}

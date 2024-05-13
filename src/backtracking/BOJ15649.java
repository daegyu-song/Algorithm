package backtracking;

import java.util.*;
import java.io.*;

public class BOJ15649 {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    arr[k] = i;
                    rec_func(k + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1];
        visit = new boolean[N + 1];

        rec_func(1);
        System.out.println(sb.toString());
    }
}

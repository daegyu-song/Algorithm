package twopointers;

import java.util.*;
import java.io.*;

public class AS11728 {
    static int N, M;
    static int[] a;
    static int[] b;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = new int[N];
        M = Integer.parseInt(st.nextToken());
        b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        int L = 0, R = 0;
        while (L < N && R < M) {
            if (a[L] <= b[R]) sb.append(a[L++]).append(" ");
            else sb.append(b[R++]).append(" ");
        }
        while (L < N) sb.append(a[L++]).append(" ");
        while (R < M) sb.append(b[R++]).append(" ");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}

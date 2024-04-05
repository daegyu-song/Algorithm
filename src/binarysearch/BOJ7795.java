package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ7795 {
    static int N;
    static int[] A, B;

    static StringBuilder sb = new StringBuilder();

    static int binarySearch(int x) {
        int L = 0;
        int R = B.length - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (B[M] < x) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return L;
    }

    static void process() {
        int answer = 0;
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += binarySearch(A[i]);
        }
        sb.append(answer).append("\n");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = new int[Integer.parseInt(st.nextToken())];
            B = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A.length; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B.length; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            process();
        }
        System.out.println(sb.toString());
    }
}

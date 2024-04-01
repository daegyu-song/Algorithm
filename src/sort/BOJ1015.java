package sort;

import java.util.*;
import java.io.*;

public class BOJ1015 {
    static int N;
    static int[] A, B;

    static StringBuilder sb  = new StringBuilder();

    static void process() {
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    sb.append(j).append(" ");
                    B[j] = 0;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        B = A.clone();

        process();
        System.out.println(sb.toString());
    }
}

package dp;

import java.io.*;
import java.util.*;

public class BOJ11052 {
    static int[] dy, numbers;

    static void preprocess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];
        dy = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dy[i] = Math.max(dy[i], dy[i - j] + numbers[j]);
            }
        }

        System.out.println(dy[n]);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
    }
}

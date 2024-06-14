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

        dy[1] = numbers[1];
        dy[2] = Math.max(dy[1] + dy[1], numbers[2]);

        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dy[j] + dy[i - j]);
            }
            dy[i] = Math.max(max, numbers[i]);
        }

        System.out.println(dy[n]);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
    }
}

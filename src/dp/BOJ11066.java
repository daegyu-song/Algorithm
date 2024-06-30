package dp;

import java.io.*;
import java.util.*;

public class BOJ11066 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K;
    static int[] numbers;
    static int[][] dy, sum;

    static void preprocess() {
        for (int i = 1; i <= K; i++){
            for (int j = i; j <= K; j++){
                sum[i][j] = sum[i][j - 1] + numbers[j];
            }
        }
    }

    static void input() throws IOException {
        K = Integer.parseInt(br.readLine());
        numbers = new int[K + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dy = new int[K + 1][K + 1];
        sum = new int[K + 1][K + 1];
    }

    static void pro() {
        preprocess();
        for (int len = 2; len <= K; len ++) {
            for (int i = 1; i <= K - len + 1; i++) {
                int j = i + len - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++){
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + sum[i][j]);
                }
            }
        }

        System.out.println(dy[1][K]);
    }


    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}

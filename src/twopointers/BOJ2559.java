package twopointers;

import java.util.*;
import java.io.*;

public class BOJ2559 {
    static int K, N;
    static int[] dates;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dates = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dates.length; i++) {
            dates[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int ans = Integer.MIN_VALUE, check = 0, sum = 0;
        for (int left = 0, right = 0; left < K; left++) {
            while (check < N && right < K) {
                sum += dates[right];
                check++;
                right++;
            }
            if (check == N) {
                ans = Math.max(ans, sum);
                check--;
                sum -= dates[left];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}

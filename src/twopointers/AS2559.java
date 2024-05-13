package twopointers;

import java.util.*;
import java.io.*;

public class AS2559 {
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
        int ans = Integer.MIN_VALUE, sum = 0;
        for (int left = 0, right = -1; left + N - 1 < K; left++) {
            while (right + 1 <= left + N - 1) {
                sum += dates[++right];
            }
            ans = Math.max(ans, sum);
            sum -= dates[left];
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}

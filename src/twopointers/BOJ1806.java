package twopointers;

import java.io.*;
import java.util.*;

public class BOJ1806 {
    static int N, S;
    static int[] numbers;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        int R = -1, sum = 0, ans = N + 1;
        for (int L = 0; L < N; L++) {
            while (R + 1 < N && sum < S) {
                sum += numbers[++R];
            }
            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
                sum -= numbers[L];
            }
        }
        if (ans == N + 1) ans = 0;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}

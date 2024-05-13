package twopointers;

import java.util.*;
import java.io.*;

public class BOJ15565 {
    static int K, N;
    static int[] doll;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        doll = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < doll.length; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        int right = -1, ans = -1, cnt = 0;
        for (int left = 0; left < N; left++) {
            while (right < N - 1 && cnt < K) {
                right++;
                if (doll[right] == 1) cnt++;
            }
            if (cnt == K) {
                if (ans == -1) ans = right - left + 1;
                ans = Math.min(ans, right - left + 1);
            }
            if (doll[left] == 1) cnt--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}

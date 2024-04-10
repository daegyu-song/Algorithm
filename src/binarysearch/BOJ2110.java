package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ2110 {
    static int N, C;
    static int[] home;

    static boolean test(int M) {
        int cnt = 1, last = home[0];
        for (int i = 1; i < home.length; i++) {
            if (home[i] - last < M) continue;
            last = home[i];
            cnt++;
        }
        return cnt >= C;
    }

    static void process() {
        Arrays.sort(home);
        int L = 1, R = 1000000000, ans = 0;

        while (L <= R) {
            int M = (L + R) / 2;
            if (test(M)) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for (int i = 0; i < home.length; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        process();
    }
}

package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ1654 {
    static int K, N;
    static int[] LAN;

    static boolean test(long M) {
        long cnt = 0;
        for (int i = 0; i < LAN.length; i++) {
            cnt += LAN[i] / M;
        }
        return cnt >= N;
    }

    static void process() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;

        while (L <= R) {
            long M = (L + R) / 2;
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
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        LAN = new int[K];
        for (int i = 0; i < LAN.length; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
        }
        process();
    }
}

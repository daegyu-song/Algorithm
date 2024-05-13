package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ13702 {
    static int N, K;
    static int[] makgeolli;

    static boolean test(long limit) {
        int cnt = 0;
        for (int i = 0; i < makgeolli.length; i++) {
            cnt += makgeolli[i] / limit;
        }
        return cnt >= K;
    }

    static void process() {
        long L = 1, R = 0, ans = 0;
        for (int i = 0; i < makgeolli.length; i++) R = Math.max(R, makgeolli[i]);
        while (L <= R) {
            long limit = (L + R) / 2;
            if (test(limit)) {
                ans = limit;
                L = limit + 1;
            } else {
                R = limit - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        makgeolli = new int[N];
        for (int i = 0; i < makgeolli.length; i++) {
            makgeolli[i] = Integer.parseInt(br.readLine());
        }
        process();
    }
}
package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2805 {
    static int N, M;
    static int[] trees;

    static boolean test(int mid) {
        long sum = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] - mid > 0) sum += trees[i] - mid;
        }
        return sum >= M;
    }

    static void process() {
        int L = 0, R = 0, ans = 0;
        for (int i = 0; i < trees.length; i++) R = Math.max(R, trees[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            if (test(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        process();
    }
}
package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ2512 {
    static int N, M;
    static int[] budget;

    static boolean test(int mid) {
        int sum = 0;
        for (int i = 0; i < budget.length; i++) {
            sum += Math.min(budget[i], mid);
        }
        return sum <= M;
    }

    static void process() {
        int L = 1, R = 0, ans = 0;
        for (int i = 0; i < budget.length; i++) R = Math.max(R, budget[i]);
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
        N = Integer.parseInt(br.readLine());
        budget = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < budget.length; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        process();
    }
}

package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ6236 {
    static int N, M;
    static int[] money;

    static boolean cntTest(int mid) {
        int cnt = 1, sum = 0;
        for (int i = 0; i < money.length; i++) {
            if (sum + money[i] > mid) {
                cnt++;
                sum = money[i];
            } else {
                sum += money[i];
            }
        }
        return cnt <= M;
    }

    static void process() {
        int L = money[0], R = 1000000000, answer = 0;
        for (int i = 0; i < money.length; i++) L = Math.max(L, money[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            if (cntTest(mid)) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];
        for (int i = 0; i < money.length; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        process();
    }
}

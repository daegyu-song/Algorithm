package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ1637 {
    static int N;
    static int[][] numbers;

    static int count(int A, int C, int B, int mid) {
        if (mid < A) return 0;
        if (C < mid) return (C - A) / B + 1;
        return (mid - A) / B + 1;
    }

    static boolean test(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += count(numbers[i][0], numbers[i][1], numbers[i][2], mid);
        }
        return sum % 2 == 1;
    }

    static void process() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0, ansCnt = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (test((int)mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        if (ans == 0) {
            System.out.println("NOTHING");
        } else {
            for (int i = 0; i < N; i++) {
                if (numbers[i][0] <= ans && ans <= numbers[i][1] && (ans - numbers[i][0]) % numbers[i][2] == 0) {
                    ansCnt++;
                }
            }
            System.out.println(ans + " " + ansCnt);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N][3];
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers[i][0] = Integer.parseInt(st.nextToken());
            numbers[i][1] = Integer.parseInt(st.nextToken());
            numbers[i][2] = Integer.parseInt(st.nextToken());
        }
        process();
    }
}

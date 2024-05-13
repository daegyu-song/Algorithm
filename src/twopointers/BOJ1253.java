package twopointers;

import java.util.*;
import java.io.*;

public class BOJ1253 {
    static int N;
    static int[] numbers;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean check(int idx) {
        int L = 0, R = N - 1;
        int target = numbers[idx];
        while (L < R) {
            if (L == idx) L++;
            else if (R == idx) R--;
            else {
                if (numbers[L] + numbers[R] > target) R--;
                else if (numbers[L] + numbers[R] == target) return true;
                else L++;
            }
        }
        return false;
    }

    static void pro() {
        Arrays.sort(numbers);
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (check(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}

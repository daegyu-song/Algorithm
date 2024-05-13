package twopointers;

import java.util.*;
import java.io.*;

public class BOJ2003 {
    static int N, M;
    static int[] numbers;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int right = -1, cnt = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            while (right + 1 < N && sum < M) {
                right++;
                sum += numbers[right];
            }
            if (sum == M) {
                cnt++;
                sum -= numbers[i];
            }
            if (sum > M) {
                sum -= numbers[i];
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}

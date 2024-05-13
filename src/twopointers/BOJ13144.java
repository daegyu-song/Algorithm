package twopointers;

import java.util.*;
import java.io.*;

public class BOJ13144 {
    static int N;
    static int[] numbers, cnt;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[100001];

    }

    static void pro() {
        long ans = 0;
        for (int left = 0, right = -1; left < N; left++) {
            while (right + 1 < N && cnt[numbers[right + 1]] == 0) {
                right++;
                cnt[numbers[right]]++;
            }
            ans += right - left + 1;

            cnt[numbers[left]]--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}

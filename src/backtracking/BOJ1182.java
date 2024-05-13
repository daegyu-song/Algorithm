package backtracking;

import java.util.*;
import java.io.*;

public class BOJ1182 {
    static int S;
    static int N;
    static int[] numbers;
    static int count = 0;

    static void solution(int idx, int size, int depth, int sum) {
        if (depth == size) {
            if (sum == S) count++;
        } else {
            for (int i = idx; i < N; i++) {
                solution(i + 1, size, depth + 1, sum + numbers[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            solution(0, i, 0, 0);
        }
        System.out.println(count);
    }
}
